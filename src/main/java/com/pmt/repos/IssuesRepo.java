package com.pmt.repos;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.models.Issue;
import com.pmt.models.Project;

public interface IssuesRepo extends JpaRepository<Issue, UUID> {

	List<Issue> findByProj(Project proj);
}
