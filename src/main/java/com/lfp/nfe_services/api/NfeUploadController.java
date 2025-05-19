package com.lfp.nfe_services.api;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

import com.lfp.nfe_services.exception.InvalidXmlException;
import com.lfp.nfe_services.service.NfeUploadService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/nfe-upload")
@Tags(value = @Tag(name = "NfeUploadController"))
public class NfeUploadController {

  private final NfeUploadService service;

  public NfeUploadController(final NfeUploadService service) {
    this.service = service;
  }

  @ResponseStatus(NO_CONTENT)
  @PostMapping(consumes = MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<Object> uploadNfe(final @RequestParam("file") MultipartFile file) {
    try {
      service.publishNfeForUpload(new String(file.getBytes()));
      return ResponseEntity.noContent().build();
    } catch (InvalidXmlException ex) {
      return ResponseEntity.badRequest().body("The XML provided is invalid, please try again.");
    } catch (Exception ex) {
      return ResponseEntity.internalServerError().body("Error uploading NFe.");
    }
  }
}
