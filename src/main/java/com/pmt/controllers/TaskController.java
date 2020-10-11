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

import com.pmt.models.Task;
import com.pmt.models.dto.Task_dto;
import com.pmt.services.TaskService;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/task")
public class TaskController {

	static final Logger logger = LogManager.getLogger(TaskController.class.getName());

	@Autowired
	private TaskService service;

	@GetMapping("/accessToken")
	public boolean getAcces() {
		return true;
	}

	// displaying list of all tasks
	@GetMapping("/")
	public List<Task> getAllTask() {
		return service.getAllTasks();
	}

	@GetMapping("/pid/{id}")
	public List<Task> getAllTasks(@PathVariable UUID id) {
		return service.getAllTasksByPID(id);
	}

	@GetMapping("/sid/{id}")
	public List<Task> getAllSprintTasks(@PathVariable UUID id) {
		return service.getAllTasksBySprintID(id);
	}

	// displaying task by id
	@GetMapping("/{id}")
	public Task getTask(@PathVariable UUID id) {
		return service.getTask(id);
	}

	// inserting task
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UUID> addTasks(@ModelAttribute Task_dto task) {
		return new ResponseEntity<>(service.cuTask(task), HttpStatus.CREATED);
	}

	// updating task by id
	@PutMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UUID> updateTask(@ModelAttribute Task_dto task) {
		return new ResponseEntity<>(service.cuTask(task), HttpStatus.OK);
	}

	// deleting all tasks
	@DeleteMapping("/")
	public void deleteAllTasks() {
		service.deleteAllTasks();
	}

	// deleting task by id
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<UUID> deleteTaskByID(@PathVariable UUID id) {
		return new ResponseEntity<>(service.deleteTaskByID(id), HttpStatus.OK);
	}

	// updating/ patching task by id
	@PatchMapping("/{id}")
	public void patchTaskByID(@RequestBody Task e, @PathVariable UUID id) {
		service.patchTask(e, id);
	}
}
