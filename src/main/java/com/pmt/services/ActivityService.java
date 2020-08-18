package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Activity;
import com.pmt.models.Employee;
import com.pmt.models.Project;
import com.pmt.repos.ActivityRepo;

@Service
public class ActivityService {

	@Autowired
	private ActivityRepo repo;

	@Autowired
	private EmployeeService empservice;

	@Autowired
	private ProjectService projectService;

	// fetching all projects
	public List<Activity> getAllActivities() {
		List<Activity> list = (List<Activity>) repo.findAll();
		return list;
	}

	// fetching project by id
	public Activity getActivity(UUID id) {
		return repo.getOne(id);
	}

	// inserting project
	public UUID addActivity(Activity c) {
		c.setActcreatedBy(empservice.getEmployee(c.getActcreatedBy().getId()));
		c.setProj(projectService.getProject(c.getProj().getId()));
		Date dtCreated = new Date();
		c.setDtCreated(dtCreated);
		repo.save(c);
		return c.getId();
	}

	// updating project by id
	public void updateActivity(Activity project, UUID id) {
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
	public void patchActivity(Activity emp, UUID id) {
		if (id == emp.getId()) {
			repo.save(emp);
		}
	}

	public void defaultActivity(Project p, Employee e, Date d) {

		Activity a1 = new Activity("Strategy", "Open", p, e, d, d);
		Activity a2 = new Activity("Design", "Open", p, e, d, d);
		Activity a3 = new Activity("Development", "Open", p, e, d, d);
		Activity a4 = new Activity("Testing", "Open", p, e, d, d);
		Activity a5 = new Activity("Deliverables", "Open", p, e, d, d);
		repo.save(a1);
		repo.save(a2);
		repo.save(a3);
		repo.save(a4);
		repo.save(a5);
	}
}
