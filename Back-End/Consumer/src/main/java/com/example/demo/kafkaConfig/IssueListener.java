package com.example.demo.kafkaConfig;

import com.example.demo.entity.Issue;
import com.example.demo.repo.IssueRepository;
import com.example.demo.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IssueListener {

    private final IssueService issueService;

    @KafkaListener(
            topics = "problem",
            groupId = "issue-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(Issue issue) {

        issueService.submitIssue(issue);
    }
}
