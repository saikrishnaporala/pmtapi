package com.pmt.repos;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.models.Employee;
import com.pmt.models.Project;

public interface ProjectRepo extends JpaRepository<Project, UUID> {

	List<Project> findByCreatedBy(Employee emp);
}
