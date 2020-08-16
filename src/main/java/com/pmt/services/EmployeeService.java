package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Employee;
import com.pmt.repos.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private DepartmentService deptService;

	// fetching all employees
	public List<Employee> getAllEmployees() {
		List<Employee> emps = (List<Employee>) repo.findAll();
		return emps;
	}

	// fetching employee by id
	public Employee getEmployee(UUID id) {
		return repo.getOne(id);
	}

	// inserting employee
	public UUID addEmployee(Employee obj, UUID comp) {
		obj.setCompany(companyService.getComp(comp));
		obj.setDept(deptService.getDepartment(obj.getDept().getId()));
		Date dtCreated = new Date();
		obj.setDtCreated(dtCreated);
		repo.save(obj);
		return obj.getId();
	}

	// updating employee by id
	public void updateEmployee(Employee user, UUID id) {
		if (id == user.getId()) {
			Date dtUpdated = new Date();
			user.setDtUpdated(dtUpdated);
			repo.save(user);
		}
	}

	// deleting all employees
	public void deleteAllEmployees() {
		repo.deleteAll();
	}

	// deleting employee by id
	public void deleteEmployeeByID(UUID id) {
		repo.deleteById(id);
	}

	// patching/updating employee by id
	public void patchEmployee(Employee obj, UUID id) {
		if (id == obj.getId()) {
			repo.save(obj);
		}
	}
}
