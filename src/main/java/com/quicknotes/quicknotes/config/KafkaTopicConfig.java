package com.quicknotes.quicknotes.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.kafka.clients.admin.NewTopic;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public  NewTopic notesEvetnsTopic() {
        return new NewTopic("notes-events", 3, (short) 1);
    }
}
