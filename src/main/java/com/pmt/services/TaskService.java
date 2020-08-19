package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Employee;
import com.pmt.models.Project;
import com.pmt.models.Task;
import com.pmt.repos.TaskRepo;

@Service
public class TaskService {

	@Autowired
	private TaskRepo repo;

	@Autowired
	private EmployeeService empservice;

	@Autowired
	private SprintService sprintService;

	// fetching all Tasks
	public List<Task> getAllTasks() {
		List<Task> list = (List<Task>) repo.findAll();
		return list;
	}

	// fetching task by id
	public Task getTask(UUID id) {
		return repo.getOne(id);
	}

	// inserting task
	public UUID addTask(Task c) {
		c.setCreatedBy(empservice.getEmployee(c.getCreatedBy().getId()));
		c.setSprint(sprintService.getSprint(c.getSprint().getId()));
		Date dtCreated = new Date();
		c.setDtCreated(dtCreated);
		repo.save(c);
		return c.getId();
	}

	// updating task by id
	public void updateTask(Task task, UUID id) {
		if (id == task.getId()) {
			Date dtUpdated = new Date();
			task.setDtUpdated(dtUpdated);
			repo.save(task);
		}
	}

	// deleting all tasks
	public void deleteAllTasks() {
		repo.deleteAll();
	}

	// deleting task by id
	public void deleteTaskByID(UUID id) {
		repo.deleteById(id);
	}

	// patching/updating task by id
	public void patchTask(Task obj, UUID id) {
		if (id == obj.getId()) {
			repo.save(obj);
		}
	}

	public void defaultTask(Project p, Employee e, Date d) {

		/*
		 * Task a1 = new Task("Strategy", "Open", p, e, d, d); Task a2 = new
		 * Task("Design", "Open", p, e, d, d); Task a3 = new Task("Development", "Open",
		 * p, e, d, d); Task a4 = new Task("Testing", "Open", p, e, d, d); Task a5 = new
		 * Task("Deliverables", "Open", p, e, d, d); repo.save(a1); repo.save(a2);
		 * repo.save(a3); repo.save(a4); repo.save(a5);
		 */
	}
}
