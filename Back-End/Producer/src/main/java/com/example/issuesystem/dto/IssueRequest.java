package com.example.issuesystem.dto;
public class IssueRequest {
    private String issueType;
    private String description;


    public String getIssueType() { return issueType; }
    public void setIssueType(String issueType) { this.issueType = issueType; }


    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}