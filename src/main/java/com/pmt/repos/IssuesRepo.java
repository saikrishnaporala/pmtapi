package com.pmt.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.models.Issue;

public interface IssuesRepo extends JpaRepository<Issue, UUID> {

}
