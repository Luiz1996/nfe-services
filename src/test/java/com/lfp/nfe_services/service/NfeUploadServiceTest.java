package com.lfp.nfe_services.service;

import static com.lfp.nfe_services.XmlBuilderUtils.getXml;
import static com.lfp.nfe_services.XmlBuilderUtils.getXmlInJson;
import static java.math.BigDecimal.TEN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lfp.nfe_services.exception.InvalidXmlException;
import com.lfp.nfe_services.kafka.KafkaProducer;
import com.lfp.nfe_services.kafka.event.NfeUploadEvent;
import com.lfp.nfe_services.model.NfeBasicDataEntity;
import com.lfp.nfe_services.repository.NfeBasicDataRepository;
import jakarta.xml.bind.JAXBException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NfeUploadServiceTest {

  @Mock
  private ObjectMapper objectMapper;

  @Mock
  private KafkaProducer kafkaProducer;

  @Mock
  private NfeBasicDataRepository nfeBasicDataRepository;

  @InjectMocks
  private NfeUploadService service;

  @Test
  void shouldPublishNfeForUpload() throws JsonProcessingException {
    when(objectMapper.writeValueAsString(any()))
        .thenReturn(getXmlInJson());

    doNothing()
        .when(kafkaProducer)
        .sendMessage(any(), any(), any());

    service.publishNfeForUpload(getXml());

    verify(objectMapper)
        .writeValueAsString(any());

    verify(kafkaProducer).sendMessage(any(), any(), any());
  }

	@Test
	void shouldNotPublishNfeForUpload() throws JsonProcessingException {
		final var exception =
				assertThrows(InvalidXmlException.class, () -> service.publishNfeForUpload(null));

		assertEquals(InvalidXmlException.class, exception.getClass());

		verify(objectMapper, never())
				.writeValueAsString(any());

		verify(kafkaProducer, never()).sendMessage(any(), any(), any());
	}

  @Test
  void shouldProcessNfeUpload() throws JAXBException {
    final var topicKey = UUID.randomUUID();
    final var nfeUploadEvent = new NfeUploadEvent(getXml());
    final var entity = new NfeBasicDataEntity(topicKey, LocalDate.now(), TEN, LocalDateTime.now());
		nfeUploadEvent.setXml(getXml());

    when(nfeBasicDataRepository.save(any()))
        .thenReturn(entity);

    service.processNfeUpload(topicKey, nfeUploadEvent);

    verify(nfeBasicDataRepository).save(any());
  }
}