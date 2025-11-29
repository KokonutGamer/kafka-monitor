package com.example.kafka_monitor.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka_monitor.services.KafkaConsumerService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final KafkaConsumerService kafkaConsumerService;

    public MessageController(KafkaConsumerService kafkaConsumerService) {
        this.kafkaConsumerService = kafkaConsumerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllMessages() {
        return ResponseEntity.ok(kafkaConsumerService.getMessages());
    }
}
