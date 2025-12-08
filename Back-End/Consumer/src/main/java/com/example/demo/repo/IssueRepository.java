package com.example.demo.repo;

import com.example.demo.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByStudentId(Long studentId);
}