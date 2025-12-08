package com.example.issuesystem.kafkaConfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic issueTopic() {
        return TopicBuilder.name("problem")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
