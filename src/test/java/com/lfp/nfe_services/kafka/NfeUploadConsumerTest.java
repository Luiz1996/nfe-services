package com.lfp.nfe_services.kafka;

import static com.lfp.nfe_services.XmlBuilderUtils.getXml;
import static com.lfp.nfe_services.XmlBuilderUtils.getXmlInJson;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lfp.nfe_services.kafka.event.NfeUploadEvent;
import com.lfp.nfe_services.service.NfeUploadService;
import jakarta.xml.bind.JAXBException;
import java.util.UUID;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NfeUploadConsumerTest {

  @Mock
  private ObjectMapper mapper;

  @Mock
  private NfeUploadService service;

  @InjectMocks
  private NfeUploadConsumer consumer;

  @Test
  void shouldConsumeMessage() throws JsonProcessingException, JAXBException {
    final var topicKey = UUID.randomUUID();
    final var consumerRecord = new ConsumerRecord<>("any-topic", 0, 0L, topicKey.toString(), getXmlInJson());
    final var event = new NfeUploadEvent(getXml());

    when(mapper.readValue(consumerRecord.value(), NfeUploadEvent.class))
        .thenReturn(event);

    doNothing()
        .when(service)
        .processNfeUpload(topicKey, event);

    consumer.consumeMessage(consumerRecord);

    verify(mapper).readValue(consumerRecord.value(), NfeUploadEvent.class);

    verify(service).processNfeUpload(topicKey, event);
  }
}