package com.pmt.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.models.Issues;

public interface IssuesRepo extends JpaRepository<Issues, UUID> {

}
