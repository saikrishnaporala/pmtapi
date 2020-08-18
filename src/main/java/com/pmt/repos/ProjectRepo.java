package com.pmt.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.models.Project;

public interface ProjectRepo extends JpaRepository<Project, UUID> {

}
