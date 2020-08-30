package com.pmt.controllers;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pmt.models.Employee;
import com.pmt.services.EmployeeService;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	static final Logger logger = LogManager.getLogger(EmployeeController.class.getName());

	@Autowired
	private EmployeeService service;

	// displaying list of all employees
	@GetMapping("/")
	public List<Employee> getAllEmployee() {
		return service.getAllEmployees();
	}

	// displaying employee by id
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable UUID id) {
		return service.getEmployee(id);
	}

	// displaying company by id
	@GetMapping("/check/{empid}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> getEmployee(@PathVariable int empid) {
		return new ResponseEntity<>(service.getEmployee(empid), HttpStatus.CREATED);
	}

	// inserting employee
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UUID> addEmployees(@RequestBody Employee obj) {
		return new ResponseEntity<>(service.addEmployee(obj), HttpStatus.CREATED);
	}

	// updating employee by id
	@PutMapping("/{id}")
	public void updateUser(@RequestBody Employee obj, @PathVariable UUID id) {
		service.updateEmployee(obj, id);
	}

	// deleting all employees
	@DeleteMapping("/")
	public void deleteAllEmployees() {
		service.deleteAllEmployees();
	}

	// deleting employee by id
	@DeleteMapping("/{id}")
	public void deleteEmployeeByID(@RequestBody Employee obj, @PathVariable UUID id) {
		service.deleteEmployeeByID(id);
	}

	// updating/ patching employee by id
	@PatchMapping("/{id}")
	public void patchEmployeeByID(@RequestBody Employee obj, @PathVariable UUID id) {
		service.patchEmployee(obj, id);
	}
}
