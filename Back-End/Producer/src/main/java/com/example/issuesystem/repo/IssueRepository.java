package com.example.issuesystem.repo;
import com.example.issuesystem.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByStudentId(Long studentId);
}