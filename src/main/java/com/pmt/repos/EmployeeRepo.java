package com.pmt.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, UUID> {

}
