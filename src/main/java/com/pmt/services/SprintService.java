package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Employee;
import com.pmt.models.Project;
import com.pmt.models.Sprint;
import com.pmt.repos.SprintRepo;

@Service
public class SprintService {

	@Autowired
	private SprintRepo repo;

	@Autowired
	private EmployeeService empservice;

	@Autowired
	private ProjectService projectService;

	// fetching all projects
	public List<Sprint> getAllSprints() {
		List<Sprint> list = (List<Sprint>) repo.findAll();
		return list;
	}

	// fetching sprint by id
	public Sprint getSprint(UUID id) {
		return repo.getOne(id);
	}

	// inserting sprint
	public UUID addSprint(Sprint c) {
		c.setActcreatedBy(empservice.getEmployee(c.getActcreatedBy().getId()));
		c.setProj(projectService.getProject(c.getProj().getId()));
		Date dtCreated = new Date();
		c.setDtCreated(dtCreated);
		repo.save(c);
		return c.getId();
	}

	// updating sprint by id
	public void updateSprint(Sprint sprint, UUID id) {
		if (id == sprint.getId()) {
			Date dtUpdated = new Date();
			sprint.setDtUpdated(dtUpdated);
			repo.save(sprint);
		}
	}

	// deleting all sprints
	public void deleteAllSprints() {
		repo.deleteAll();
	}

	// deleting sprint by id
	public void deleteSprintByID(UUID id) {
		repo.deleteById(id);
	}

	// patching/updating sprint by id
	public void patchSprint(Sprint emp, UUID id) {
		if (id == emp.getId()) {
			repo.save(emp);
		}
	}

	public void defaultSprint(Project p, Employee e, Date d) {

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
