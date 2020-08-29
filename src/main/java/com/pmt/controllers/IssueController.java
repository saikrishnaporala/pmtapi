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

import com.pmt.models.Issue;
import com.pmt.services.IssueService;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/issues")
public class IssueController {

	static final Logger logger = LogManager.getLogger(IssueController.class.getName());

	@Autowired
	private IssueService service;

	// displaying list of all issues
	@GetMapping("/")
	public List<Issue> getAllIssue() {
		return service.getAllIssues();
	}

	// displaying issue by id
	@GetMapping("/{id}")
	public Issue getIssue(@PathVariable UUID id) {
		return service.getIssue(id);
	}

	// inserting issue
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UUID> addIssues(@RequestBody Issue issue) {
		return new ResponseEntity<>(service.addIssue(issue), HttpStatus.CREATED);
	}

	// updating issue by id
	@PutMapping("/{id}")
	public void updateIssue(@RequestBody Issue e, @PathVariable UUID id) {
		service.updateIssue(e, id);
	}

	// deleting all issues
	@DeleteMapping("/")
	public void deleteAllIssues() {
		service.deleteAllIssues();
	}

	// deleting issue by id
	@DeleteMapping("/{id}")
	public void deleteIssueByID(@RequestBody Issue e, @PathVariable UUID id) {
		service.deleteIssueByID(id);
	}

	// updating/ patching issue by id
	@PatchMapping("/{id}")
	public void patchIssueByID(@RequestBody Issue e, @PathVariable UUID id) {
		service.patchIssue(e, id);
	}
}
