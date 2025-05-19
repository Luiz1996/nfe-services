package com.lfp.nfe_services.service;

import static com.lfp.nfe_services.kafka.KafkaTopicNames.NFE_UPLOAD;
import static com.lfp.nfe_services.utils.XmlUtils.parseToNfeObject;
import static org.springframework.util.StringUtils.hasText;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lfp.nfe_services.exception.InvalidXmlException;
import com.lfp.nfe_services.kafka.KafkaProducer;
import com.lfp.nfe_services.kafka.event.NfeUploadEvent;
import com.lfp.nfe_services.model.NfeBasicDataEntity;
import com.lfp.nfe_services.repository.NfeBasicDataRepository;
import jakarta.xml.bind.JAXBException;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class NfeUploadService {

  private final ObjectMapper objectMapper;
  private final KafkaProducer kafkaProducer;
  private final NfeBasicDataRepository nfeBasicDataRepository;

  public NfeUploadService(
      final ObjectMapper objectMapper,
      final KafkaProducer kafkaProducer,
      final NfeBasicDataRepository nfeBasicDataRepository) {
    this.objectMapper = objectMapper;
    this.kafkaProducer = kafkaProducer;
    this.nfeBasicDataRepository = nfeBasicDataRepository;
  }

  public void publishNfeForUpload(final String xmlContent) throws JsonProcessingException {
    if (!hasText(xmlContent)) {
      throw new InvalidXmlException();
    }
    kafkaProducer
        .sendMessage(
            UUID.randomUUID().toString(),
            NFE_UPLOAD,
            objectMapper.writeValueAsString(new NfeUploadEvent(xmlContent)));
  }

  public void processNfeUpload(final UUID topicKey, final NfeUploadEvent nfeUploadEvent) throws JAXBException {
    final var nfe = parseToNfeObject(nfeUploadEvent.getXml());

    final var nfeBasicData = new NfeBasicDataEntity(
        topicKey,
        nfe.getInfNfe().getIde().getdEmi(),
        nfe.getInfNfe().getTotal().getIcmsTot().getvNf(),
        nfeUploadEvent.getDateTime());

    nfeBasicDataRepository.save(nfeBasicData);
  }
}
