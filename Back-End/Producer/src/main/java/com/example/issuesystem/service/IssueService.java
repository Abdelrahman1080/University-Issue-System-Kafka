package com.example.issuesystem.service;

import com.example.issuesystem.entity.Issue;
import com.example.issuesystem.repo.IssueRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {
    private final IssueRepository repo;
    public IssueService(IssueRepository repo ) {
        this.repo = repo;
    }
    public Issue submitIssue(Issue issue) {

        Issue saved = repo.save(issue);
        String json = "{\"id\":"+saved.getId()+",\"studentId\":"+saved.getStudentId()+",\"type\":\""+saved.getIssueType()+"\"}";
        return saved;
    }
    public List<Issue> getAllIssues() { return repo.findAll(); }
    public List<Issue> getIssuesByStudent(Long studentId) { return repo.findByStudentId(studentId); }
    public void deleteIssue(Long id) { repo.deleteById(id); }
    public void updateIssueStatus(Long id, String status) {
        repo.findById(id).ifPresent(issue -> {
            issue.setStatus(status);
            repo.save(issue); // <- persist the change
        });
    }}

