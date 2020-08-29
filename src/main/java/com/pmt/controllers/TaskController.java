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

import com.pmt.models.Task;
import com.pmt.services.TaskService;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/task")
public class TaskController {

	static final Logger logger = LogManager.getLogger(TaskController.class.getName());

	@Autowired
	private TaskService service;

	// displaying list of all tasks
	@GetMapping("/")
	public List<Task> getAllTask() {
		return service.getAllTasks();
	}

	// displaying task by id
	@GetMapping("/{id}")
	public Task getTask(@PathVariable UUID id) {
		return service.getTask(id);
	}

	// inserting task
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UUID> addTasks(@RequestBody Task task) {
		return new ResponseEntity<>(service.addTask(task), HttpStatus.CREATED);
	}

	// updating task by id
	@PutMapping("/{id}")
	public void updateTask(@RequestBody Task e, @PathVariable UUID id) {
		service.updateTask(e, id);
	}

	// deleting all tasks
	@DeleteMapping("/")
	public void deleteAllTasks() {
		service.deleteAllTasks();
	}

	// deleting task by id
	@DeleteMapping("/{id}")
	public void deleteTaskByID(@RequestBody Task e, @PathVariable UUID id) {
		service.deleteTaskByID(id);
	}

	// updating/ patching task by id
	@PatchMapping("/{id}")
	public void patchTaskByID(@RequestBody Task e, @PathVariable UUID id) {
		service.patchTask(e, id);
	}
}
