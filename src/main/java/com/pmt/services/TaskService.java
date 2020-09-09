package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Project;
import com.pmt.models.Task;
import com.pmt.models.dto.Task_dto;
import com.pmt.repos.TaskRepo;

@Service
public class TaskService {

	@Autowired
	private TaskRepo repo;

	@Autowired
	private EmployeeService empservice;

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
		if (obj.getId() == null) {
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
		return task.getId();
		/*
		 * List<Employee> l = new ArrayList<Employee>(); c.getEmployees().forEach(item
		 * -> { l.add(empservice.getEmployee(item.getId())); }); c.setEmployees(l);
		 */
	}

	private Task mappingDTO(Task_dto obj) {
		Task c1 = new Task();
		if (obj.getId() != null) {
			c1 = this.getTask(obj.getId());
		}
		c1.setTaskName(obj.getTaskName());
		c1.setTaskType(obj.getTaskType());
		c1.setStartDate(obj.getStartDate());
		c1.setEndDate(obj.getEndDate());
		c1.setPriority(obj.getPriority());
		c1.setTaskDescr(obj.getTaskDescr());
		c1.setStatus(obj.getStatus());
		c1.setIsactive(obj.getIsactive());
		c1.setReview(obj.getReview());
		c1.setRevision(obj.getRevision());
		c1.setComments(obj.getComments());
		c1.setCreatedBy(empservice.getEmployee(obj.getCreatedBy()));
		c1.setProj(projservice.getProject(obj.getProj()));
		return c1;
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

	public List<Task> getAllTasksByPID(UUID id) {
		System.out.println("pid: " + id);
		Project proj = new Project();
		proj.setId(id);
		List<Task> list = (List<Task>) repo.findByProj(proj);
		// list.sort(Comparator.comparing(Sprint_dto::getSeq));
		return list;
	}
}
