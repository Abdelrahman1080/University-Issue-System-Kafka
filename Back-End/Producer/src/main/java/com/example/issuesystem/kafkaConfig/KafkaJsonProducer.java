package com.example.issuesystem.kafkaConfig;

import com.example.issuesystem.entity.Issue;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {

    private final KafkaTemplate<String, Issue> kafkaTemplate;

    public void sendMessage(Issue issue) {
        Message<Issue> message = MessageBuilder
                .withPayload(issue)
                .setHeader(KafkaHeaders.TOPIC, "problem")
                .setHeader(KafkaHeaders.KEY, String.valueOf(issue.getStudentId()))

                .build();

        kafkaTemplate.send(message);
        System.out.println("Sent issue to Kafka: " + issue.getIssueType());
    }

}

