package com.lfp.nfe_services.kafka;

import static com.lfp.nfe_services.kafka.KafkaTopicNames.NFE_UPLOAD;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lfp.nfe_services.kafka.event.NfeUploadEvent;
import com.lfp.nfe_services.service.NfeUploadService;
import jakarta.xml.bind.JAXBException;
import java.util.UUID;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NfeUploadConsumer {

  private final ObjectMapper mapper;
  private final NfeUploadService service;

  public NfeUploadConsumer(final ObjectMapper mapper, final NfeUploadService service) {
    this.mapper = mapper;
    this.service = service;
  }

  @KafkaListener(topics = NFE_UPLOAD, groupId = "${spring.kafka.consumer.group-id:nfe.services.group}")
  public void consumeMessage(final ConsumerRecord<String, String> consumerRecord)
      throws JsonProcessingException, JAXBException {
    final var topicKey = UUID.fromString(consumerRecord.key());
    final var topicMessageEvent = mapper.readValue(consumerRecord.value(), NfeUploadEvent.class);

    service.processNfeUpload(topicKey, topicMessageEvent);
  }
}
