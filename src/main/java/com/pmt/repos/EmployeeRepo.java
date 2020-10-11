package com.pmt.repos;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pmt.models.Employee;
import com.pmt.models.Task;

public interface EmployeeRepo extends JpaRepository<Employee, UUID> {

	public Employee findByEmpid(int empid);

	public Optional<Employee> findById(UUID id);

	@Query(value = "select MAX(emp.empid) from Employee emp")
	int findMaxEmpId();

	public Employee findByUsername(String username);

	@Query(value = "select tasks from Employee emp")
	public Set<Task> findByTasks(UUID id);
}
