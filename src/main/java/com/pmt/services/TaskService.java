package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Employee;
import com.pmt.models.Project;
import com.pmt.models.Sprint;
import com.pmt.models.Task;
import com.pmt.models.dto.Task_dto;
import com.pmt.repos.EmployeeRepo;
import com.pmt.repos.TaskRepo;

@Service
public class TaskService {

	@Autowired
	private TaskRepo repo;

	@Autowired(required = true)
	private EmployeeRepo erepo;

	@Autowired
	private ProjectService projservice;

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
	public UUID cuTask(Task_dto obj) {
		Task task = mappingDTO(obj);
		if (obj.getTaskid() == null) {
			task.setDtCreated(new Date());
		} else {
			task.setDtUpdated(new Date());
		}

		/*
		 * MultipartFile m = obj.getPhoto(); String s = m.getOriginalFilename(); proj =
		 * repo.save(proj); if (m.getOriginalFilename() != null) { s =
		 * proj.getCompany().getId() + "/employee/" + proj.getId().toString(); String
		 * fileName = imgl.storeFile(m, s);
		 * 
		 * String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
		 * .path("/companyprofiles/" + s + "/").path(fileName).toUriString();
		 * proj.setPhoto(fileDownloadUri); repo.save(proj); }
		 */

		task = repo.save(task);
		for (UUID emp : obj.getTaskEmployees()) {
			Employee e = erepo.getOne(emp);
			System.out.println("employee : " + e.getId());
			e.getTasks().add(task);
			erepo.save(e);
		}
		Employee e = erepo.getOne(obj.getTaskCreatedBy());
		e.getTaskCreatedBy().add(task);
		System.out.println(e.getTaskCreatedBy().toString());
		erepo.save(e);
		return task.getTaskid();
	}

	private Task mappingDTO(Task_dto obj) {
		Task c1 = new Task();
		if (obj.getTaskid() != null) {
			c1 = this.getTask(obj.getTaskid());
		}
		c1.setTaskName(obj.getTaskName());
		c1.setTaskSprint(sprintService.getSprint(obj.getTaskSprint()));
		c1.setTaskType(obj.getTaskType());
		if (obj.getTaskType() == "subtask") {
			c1.setTaskParent(this.getTask(obj.getTaskParent()));
		}
		c1.setTaskStartDate(obj.getTaskStartDate());
		c1.setTaskEndDate(obj.getTaskEndDate());
		c1.setTaskPriority(obj.getTaskPriority());
		c1.setTaskDescr(obj.getTaskDescr());
		c1.setTaskStatus(obj.getTaskStatus());
		c1.setTaskIsactive(obj.getTaskIsactive());
		c1.setTaskReview(obj.getTaskReview());
		c1.setTaskComments(obj.getTaskComments());
		c1.setTaskCreatedBy(erepo.getOne(obj.getTaskCreatedBy()));
		c1.setTaskProj(projservice.getProject(obj.getTaskProj()));
		Set<Employee> employees = obj.getTaskEmployees().stream().map(u -> erepo.getOne(u)).collect(Collectors.toSet());
		c1.setTaskEmployees(employees);
//
//		for (UUID emp : obj.getTaskEmployees()) {
//			Employee e = erepo.getOne(emp);
//			System.out.println("employee : " + e.getId());
//			Set<Employee> s = c1.getTaskEmployees();
//			s.add(e);
//		}

		return c1;

	}

	// deleting all tasks
	public void deleteAllTasks() {
		repo.deleteAll();
	}

	// deleting task by id
	public void deleteTaskByID(UUID id) {
		Task p = repo.getOne(id);
		for (Employee emp : p.getTaskEmployees()) {
			Employee e = erepo.getOne(emp.getId());
			System.out.println("employee : " + e.getId());
			e.getTaskCreatedBy().removeIf(s1 -> s1.equals(p));
			erepo.save(e);
		}
		Employee e = p.getTaskCreatedBy();
		e.getTaskCreatedBy().removeIf(s1 -> s1.equals(p));
		System.out.println(e.getTaskCreatedBy().toString());
		// erepo.save(e);
		// repo.deleteById(id);
	}

	// patching/updating task by id
	public void patchTask(Task obj, UUID id) {
		if (id == obj.getTaskid()) {
			repo.save(obj);
		}
	}

	public List<Task> getAllTasksByPID(UUID id) {
		System.out.println("pid: " + id);
		Project proj = new Project();
		proj.setId(id);
		List<Task> list = (List<Task>) repo.findByTaskProj(proj);
		// list.sort(Comparator.comparing(Sprint_dto::getSeq));
		return list;
	}

	public List<Task> getAllTasksBySprintID(UUID id) {
		System.out.println("sid: " + id);
		Sprint s = new Sprint();
		s.setSprintid(id);
		List<Task> list = (List<Task>) repo.findByTaskSprint(s);
		// list.sort(Comparator.comparing(Sprint_dto::getSeq));
		return list;
	}

}
