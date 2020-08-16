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

import com.pmt.models.Department;
import com.pmt.services.DepartmentService;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/dept")
public class DeptController {

	static final Logger logger = LogManager.getLogger(DeptController.class.getName());

	@Autowired
	private DepartmentService service;

	// displaying list of all departments
	@GetMapping("/")
	public List<Department> getAllDepts() {
		return service.getAllDepartments();
	}

	// displaying dept by id
	@GetMapping("/{id}")
	public Department getDept(@PathVariable UUID id) {
		return service.getDepartment(id);
	}

	// inserting dept
	@PostMapping("/{comp}/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UUID> addDepts(@PathVariable(value = "comp") UUID comp, @RequestBody Department dept) {
		return new ResponseEntity<>(service.addDepartment(dept, comp), HttpStatus.CREATED);
	}

	// updating dept by id
	@PutMapping("/{id}")
	public void updateDept(@RequestBody Department e, @PathVariable UUID id) {
		service.updateDepartment(e, id);
	}

	// deleting all dept
	@DeleteMapping("/")
	public void deleteAllDepartments() {
		service.deleteAllDepartments();
	}

	// deleting dept by id
	@DeleteMapping("/{id}")
	public void deleteDeptByID(@RequestBody Department e, @PathVariable UUID id) {
		service.deleteDepartmentByID(id);
	}

	// updating/ patching dept by id
	@PatchMapping("users/{id}")
	public void patchUserByID(@RequestBody Department e, @PathVariable UUID id) {
		service.patchDepartment(e, id);
		;
	}
}
