package com.example.issuesystem.controller;


import com.example.issuesystem.dto.IssueRequest;
import com.example.issuesystem.entity.Issue;
import com.example.issuesystem.kafkaConfig.KafkaJsonProducer;
import com.example.issuesystem.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/issues")
public class IssueController {


    private final IssueService issueService;
    KafkaJsonProducer kafkaJsonProducer;
    public IssueController(IssueService issueService,KafkaJsonProducer kafkaJsonProducer) {
        this.issueService = issueService;
        this.kafkaJsonProducer = kafkaJsonProducer;
    }


    @PostMapping("/submit/{studentId}")
    public Issue submitIssue(@PathVariable Long studentId, @RequestBody IssueRequest request) {
        Issue issue = new Issue();
        issue.setStudentId(studentId);
        issue.setIssueType(request.getIssueType());
        issue.setDescription(request.getDescription());
        kafkaJsonProducer.sendMessage(issue);
        return issueService.submitIssue(issue);
    }
    @PutMapping("/update/{id}")
    public void updateIssueStatus(@PathVariable Long id, @RequestBody String status) {
        issueService.updateIssueStatus(id, status);
    }

    @GetMapping("/all")
    public List<Issue> getAllIssues() {
        return issueService.getAllIssues();
    }


    @GetMapping("/student/{studentId}")
    public List<Issue> getStudentIssues(@PathVariable Long studentId) {
        return issueService.getIssuesByStudent(studentId);
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){issueService.deleteIssue(id);}
}