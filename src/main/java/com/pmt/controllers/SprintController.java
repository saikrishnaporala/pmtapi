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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pmt.models.Sprint;
import com.pmt.models.dto.Sprint_dto;
import com.pmt.services.SprintService;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/sprint")
public class SprintController {

	static final Logger logger = LogManager.getLogger(SprintController.class.getName());

	@Autowired
	private SprintService service;

	// displaying list of all sprints
	@GetMapping("/")
	public List<Sprint> getAllSprint() {
		return service.getAllSprints();
	}

	@GetMapping("/pid/{id}")
	public List<Sprint> getAllSprint(@PathVariable UUID id) {
		return service.getAllSprintsByPID(id);
	}

	// displaying sprint by id
	@GetMapping("/{id}")
	public Sprint getSprint(@PathVariable UUID id) {
		return service.getSprint(id);
	}

	// inserting sprint
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UUID> CUSprints(@ModelAttribute Sprint_dto sprint_dto) {
		return new ResponseEntity<>(service.CUSprint(sprint_dto), HttpStatus.CREATED);
	}

	// updating sprint by id
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<UUID> updateSprint(@RequestBody Sprint_dto sprint_dto, @PathVariable UUID id) {
		return new ResponseEntity<>(service.CUSprint(sprint_dto), HttpStatus.CREATED);
	}

	// deleting all sprints
	@DeleteMapping("/")
	public void deleteAllSprints() {
		service.deleteAllSprints();
	}

	// deleting sprint by id
	@DeleteMapping("/{id}")
	public void deleteSprintByID(@RequestBody Sprint e, @PathVariable UUID id) {
		service.deleteSprintByID(id);
	}

	// updating/ patching sprint by id
	@PatchMapping("/{id}")
	public void patchSprintByID(@RequestBody Sprint e, @PathVariable UUID id) {
		service.patchSprint(e, id);
	}
}
