package com.quicknotes.quicknotes.kafka;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

@ConditionalOnProperty(name = "kafka.enabled", havingValue = "true", matchIfMissing = false)
@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "notes-events", groupId = "quicknotes-group")
    public void consume(String message) {
        System.out.println("Consumed ← " + message);
    }
}