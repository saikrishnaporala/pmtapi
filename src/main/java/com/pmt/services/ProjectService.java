package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Employee;
import com.pmt.models.Project;
import com.pmt.repos.ProjectRepo;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepo repo;

	@Autowired
	private EmployeeService service;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private SprintService activityService;

	// fetching all projects
	public List<Project> getAllProjects() {
		List<Project> emps = (List<Project>) repo.findAll();
		return emps;
	}

	// fetching project by id
	public Project getProject(UUID id) {
		return repo.getOne(id);
	}

	// inserting project
	public UUID addProject(Project c) {
		c.setCompany(companyService.getComp(c.getCompany().getId()));
		Employee e = service.getEmployee(c.getCreatedBy().getId());
		c.setCreatedBy(e);
		Date dtCreated = new Date();
		c.setDtCreated(dtCreated);
		repo.save(c);
		activityService.defaultActivity(c, e, dtCreated);
		return c.getId();
	}

	// updating project by id
	public void updateProject(Project project, UUID id) {
		if (id == project.getId()) {
			Date dtUpdated = new Date();
			project.setDtUpdated(dtUpdated);
			repo.save(project);
		}
	}

	// deleting all projects
	public void deleteAllProjects() {
		repo.deleteAll();
	}

	// deleting project by id
	public void deleteProjectByID(UUID id) {
		repo.deleteById(id);
	}

	// patching/updating project by id
	public void patchProject(Project emp, UUID id) {
		if (id == emp.getId()) {
			repo.save(emp);
		}
	}
}
