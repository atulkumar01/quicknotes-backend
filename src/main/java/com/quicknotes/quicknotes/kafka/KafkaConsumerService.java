package com.quicknotes.quicknotes.kafka;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;


@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "notes-events", groupId = "quicknotes-group")
    public void consume(String message) {
        System.out.println("Consumed ← " + message);
    }
}