package com.lfp.nfe_services.api;

import static com.lfp.nfe_services.XmlBuilderUtils.getXml;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.springframework.http.MediaType.TEXT_XML_VALUE;
import static org.springframework.util.StringUtils.hasText;

import com.lfp.nfe_services.exception.InvalidXmlException;
import com.lfp.nfe_services.service.NfeUploadService;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

@ExtendWith(MockitoExtension.class)
class NfeUploadControllerTest {

  @Mock
  private NfeUploadService service;

  @InjectMocks
  private NfeUploadController controller;

  @Test
  void shouldUploadNfe() throws IOException {
    final var file = new MockMultipartFile("file", "nfe.xml", TEXT_XML_VALUE, getXml().getBytes());

    doNothing()
        .when(service)
        .publishNfeForUpload(any());

		final var result = controller.uploadNfe(file);

		assertNull(result.getBody());

    verify(service).publishNfeForUpload(any());
  }

	@Test
	void shouldNotUploadNfe() throws IOException {
		final var file = new MockMultipartFile("file", "nfe.xml", TEXT_XML_VALUE, getXml().getBytes());

		doThrow(new RuntimeException("Any Error"))
				.when(service)
				.publishNfeForUpload(any());

		final var result = controller.uploadNfe(file);

		final var response = result.getBody();

		assertTrue(hasText(response.toString()));

		verify(service).publishNfeForUpload(any());
	}

	@Test
	void shouldNotUploadNfeBecauseXmlIsInvalid() throws IOException {
		final var file = new MockMultipartFile("file", "nfe.xml", TEXT_XML_VALUE, "".getBytes());

		doThrow(new InvalidXmlException())
				.when(service)
				.publishNfeForUpload(any());

		final var result = controller.uploadNfe(file);

		final var response = result.getBody();

		assertTrue(hasText(response.toString()));

		verify(service).publishNfeForUpload(any());
	}
}