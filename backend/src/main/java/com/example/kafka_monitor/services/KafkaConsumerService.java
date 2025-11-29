package com.example.kafka_monitor.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final String TOPIC = "my_kafka_topic";

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = TOPIC, groupId = "messageGroup")
    public void listen(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        List<String> currentMessages = new ArrayList<>(messages);
        messages.clear();
        return currentMessages;
    }
}
