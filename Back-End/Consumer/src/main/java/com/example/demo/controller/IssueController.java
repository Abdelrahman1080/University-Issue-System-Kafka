package com.example.demo.controller;


import com.example.demo.dto.IssueRequest;
import com.example.demo.entity.Issue;
import com.example.demo.service.IssueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/issues")
public class IssueController {


    private final IssueService issueService;


    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }


    @PostMapping("/submit/{studentId}")
    public Issue submitIssue(@PathVariable Long studentId, @RequestBody IssueRequest request) {
        Issue issue = new Issue();
        issue.setStudentId(studentId);
        issue.setIssueType(request.getIssueType());
        issue.setDescription(request.getDescription());
        return issueService.submitIssue(issue);
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