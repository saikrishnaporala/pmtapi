package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Sprint;
import com.pmt.models.Employee;
import com.pmt.models.Project;
import com.pmt.repos.SprintRepo;

@Service
public class TaskService {

	@Autowired
	private SprintRepo repo;

	@Autowired
	private EmployeeService empservice;

	@Autowired
	private ProjectService projectService;

	// fetching all projects
	public List<Sprint> getAllActivities() {
		List<Sprint> list = (List<Sprint>) repo.findAll();
		return list;
	}

	// fetching project by id
	public Sprint getActivity(UUID id) {
		return repo.getOne(id);
	}

	// inserting project
	public UUID addActivity(Sprint c) {
		c.setActcreatedBy(empservice.getEmployee(c.getActcreatedBy().getId()));
		c.setProj(projectService.getProject(c.getProj().getId()));
		Date dtCreated = new Date();
		c.setDtCreated(dtCreated);
		repo.save(c);
		return c.getId();
	}

	// updating project by id
	public void updateActivity(Sprint project, UUID id) {
		if (id == project.getId()) {
			Date dtUpdated = new Date();
			project.setDtUpdated(dtUpdated);
			repo.save(project);
		}
	}

	// deleting all projects
	public void deleteAllActivitys() {
		repo.deleteAll();
	}

	// deleting project by id
	public void deleteActivityByID(UUID id) {
		repo.deleteById(id);
	}

	// patching/updating project by id
	public void patchActivity(Sprint emp, UUID id) {
		if (id == emp.getId()) {
			repo.save(emp);
		}
	}

	public void defaultActivity(Project p, Employee e, Date d) {

		Sprint a1 = new Sprint("Strategy", "Open", p, e, d, d);
		Sprint a2 = new Sprint("Design", "Open", p, e, d, d);
		Sprint a3 = new Sprint("Development", "Open", p, e, d, d);
		Sprint a4 = new Sprint("Testing", "Open", p, e, d, d);
		Sprint a5 = new Sprint("Deliverables", "Open", p, e, d, d);
		repo.save(a1);
		repo.save(a2);
		repo.save(a3);
		repo.save(a4);
		repo.save(a5);
	}
}
