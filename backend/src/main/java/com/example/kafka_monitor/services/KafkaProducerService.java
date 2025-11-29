package com.example.kafka_monitor.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "my_kafka_topic";
    private static final Logger log = LoggerFactory.getLogger(KafkaProducerService.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 10000)
    public void sendMessage() {
        String message = "Hello world: the time is "
                + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        kafkaTemplate.send(TOPIC, message).whenComplete(
                (stringStringSendResult, throwable) -> log.info("Message result {}", stringStringSendResult));
    }

}