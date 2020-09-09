package com.pmt.repos;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pmt.models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, UUID> {

	public Employee findByEmpid(int empid);

	public Optional<Employee> findById(UUID id);

	@Query(value = "select MAX(emp.empid) from Employee emp")
	int findMaxEmpId();

	public Employee findByUsername(String username);
}
