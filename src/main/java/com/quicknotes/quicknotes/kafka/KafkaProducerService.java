package com.quicknotes.quicknotes.kafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "notes-events";
    private final KafkaTemplate<String, String>  kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void  publishNoteCreated(String message) {
        kafkaTemplate.send(TOPIC, message).whenComplete((result, ex) ->
        {
            if (ex == null) {
                System.out.println("Produced → topic=" + result.getRecordMetadata().topic() +
                        ", partition=" + result.getRecordMetadata().partition() +
                        ", offset=" + result.getRecordMetadata().offset() +
                        ", payload=" + message);
            } else {
                System.err.println("Produce failed: " + ex.getMessage());
            }
        });
          }

}
