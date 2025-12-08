package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Issue {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long studentId;
    private String issueType; // TUITION_FEES, COURSE_REGISTRATION, GRADUATION_PROJECT, DOCUMENTS_REQUEST
    private String description;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }


    public String getIssueType() { return issueType; }
    public void setIssueType(String issueType) { this.issueType = issueType; }


    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}