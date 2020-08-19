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

import com.pmt.models.Project;
import com.pmt.services.ProjectService;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/activity")
public class IssuesController {

	static final Logger logger = LogManager.getLogger(IssuesController.class.getName());

	@Autowired
	private ProjectService service;

	// displaying list of all projects
	@GetMapping("/")
	public List<Project> getAllProject() {
		return service.getAllProjects();
	}

	// displaying project by id
	@GetMapping("/{id}")
	public Project getProject(@PathVariable UUID id) {
		return service.getProject(id);
	}

	// inserting project
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UUID> addProjects(@RequestBody Project project) {
		return new ResponseEntity<>(service.addProject(project), HttpStatus.CREATED);
	}

	// updating project by id
	@PutMapping("/{id}")
	public void updateProject(@RequestBody Project e, @PathVariable UUID id) {
		service.updateProject(e, id);
	}

	// deleting all projects
	@DeleteMapping("/")
	public void deleteAllProjects() {
		service.deleteAllProjects();
	}

	// deleting project by id
	@DeleteMapping("/{id}")
	public void deleteProjectByID(@RequestBody Project e, @PathVariable UUID id) {
		service.deleteProjectByID(id);
	}

	// updating/ patching project by id
	@PatchMapping("/{id}")
	public void patchProjectByID(@RequestBody Project e, @PathVariable UUID id) {
		service.patchProject(e, id);
	}
}
