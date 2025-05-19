package com.lfp.nfe_services.kafka;

import static com.lfp.nfe_services.kafka.KafkaTopicNames.NFE_UPLOAD;
import static com.lfp.nfe_services.kafka.KafkaTopicNames.NFE_UPLOAD_DLT;
import static org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.RETRIES_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.UnmarshalException;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.ExponentialBackOff;

@EnableKafka
@Configuration
public class KafkaConfig {

  private static final Integer NUM_PARTITIONS = 24;

  @Bean
  public KafkaAdmin kafkaAdmin() {
    return new KafkaAdmin(buildMapOfKafkaConfigs());
  }

  @Bean
  public NewTopic topicAddition() {
    return new NewTopic(NFE_UPLOAD, NUM_PARTITIONS, (short) 3);
  }

  @Bean
  public NewTopic dltTopicAddition() {
    return new NewTopic(NFE_UPLOAD_DLT, 1, (short) 1);
  }

  @Bean
  public ProducerFactory<String, String> producerFactory() {
    return new DefaultKafkaProducerFactory<>(buildMapOfKafkaConfigs());
  }

  @Bean
  public KafkaTemplate<String, String> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }

  @Value("${spring.kafka.bootstrap-servers:localhost}")
  private String kafkaBootstrapServers;

  private Map<String, Object> buildMapOfKafkaConfigs() {
    Map<String, Object> configProps = new HashMap<>();
    configProps.put(BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServers);
    configProps.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configProps.put(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configProps.put(RETRIES_CONFIG, 5);

    return configProps;
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(
      final ConsumerFactory<String, String> consumerFactory,
      final KafkaTemplate<String, String> kafkaTemplate) {

    ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory);
    factory.setConcurrency(NUM_PARTITIONS);

    DeadLetterPublishingRecoverer recoverer = new DeadLetterPublishingRecoverer(
        kafkaTemplate, (consumerRecord, ex) -> new TopicPartition(NFE_UPLOAD_DLT, 0));

    final var backOff = new ExponentialBackOff();
    backOff.setInitialInterval(1000L);
    backOff.setMultiplier(2);
    backOff.setMaxInterval(16000L);
    backOff.setMaxElapsedTime(31000L);

    DefaultErrorHandler errorHandler = new DefaultErrorHandler(recoverer, backOff);

    errorHandler
        .addNotRetryableExceptions(
            JAXBException.class,
            UnmarshalException.class,
            NullPointerException.class);

    factory.setCommonErrorHandler(errorHandler);

    return factory;
  }

  @Value("${spring.kafka.consumer.group-id:nfe.services.group}")
  private String groupId;

  @Bean
  public ConsumerFactory<String, String> consumerFactory() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServers);
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);

    return new DefaultKafkaConsumerFactory<>(props);
  }
}
