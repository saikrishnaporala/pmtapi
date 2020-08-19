package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Employee;
import com.pmt.models.Issues;
import com.pmt.models.Project;
import com.pmt.repos.IssuesRepo;

@Service
public class IssuesService {

	@Autowired
	private IssuesRepo repo;

	@Autowired
	private EmployeeService empservice;

	@Autowired
	private ProjectService projservice;

	@Autowired
	private SprintService sprintService;

	// fetching all Issues
	public List<Issues> getAllIssues() {
		List<Issues> list = (List<Issues>) repo.findAll();
		return list;
	}

	// fetching issue by id
	public Issues getIssues(UUID id) {
		return repo.getOne(id);
	}

	// inserting issue
	public UUID addIssues(Issues c) {
		c.setCreatedBy(empservice.getEmployee(c.getCreatedBy().getId()));
		if (c.getProject() == null) {
			c.setProject(projservice.getProject(c.getProject().getId()));
		}
		if (c.getSprint() == null) {
			c.setSprint(sprintService.getSprint(c.getSprint().getId()));
		}
		Date dtCreated = new Date();
		c.setDtCreated(dtCreated);
		repo.save(c);
		return c.getId();
	}

	// updating issue by id
	public void updateIssues(Issues obj, UUID id) {
		if (id == obj.getId()) {
			Date dtUpdated = new Date();
			obj.setDtUpdated(dtUpdated);
			repo.save(obj);
		}
	}

	// deleting all issues
	public void deleteAllIssues() {
		repo.deleteAll();
	}

	// deleting issue by id
	public void deleteIssuesByID(UUID id) {
		repo.deleteById(id);
	}

	// patching/updating issue by id
	public void patchIssues(Issues obj, UUID id) {
		if (id == obj.getId()) {
			repo.save(obj);
		}
	}

	public void defaultIssues(Project p, Employee e, Date d) {

		/*
		 * Issues a1 = new Issues("Strategy", "Open", p, e, d, d); Issues a2 = new
		 * Issues("Design", "Open", p, e, d, d); Issues a3 = new Issues("Development",
		 * "Open", p, e, d, d); Issues a4 = new Issues("Testing", "Open", p, e, d, d);
		 * Issues a5 = new Issues("Deliverables", "Open", p, e, d, d); repo.save(a1);
		 * repo.save(a2); repo.save(a3); repo.save(a4); repo.save(a5);
		 */
	}
}
