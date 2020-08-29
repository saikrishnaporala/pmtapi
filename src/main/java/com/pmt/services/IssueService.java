package com.pmt.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Employee;
import com.pmt.models.Issue;
import com.pmt.models.Project;
import com.pmt.repos.IssuesRepo;

@Service
public class IssueService {

	@Autowired
	private IssuesRepo repo;

	@Autowired
	private EmployeeService empservice;

	@Autowired
	private ProjectService projservice;

	@Autowired
	private SprintService sprintService;

	// fetching all Issue
	public List<Issue> getAllIssues() {
		List<Issue> list = (List<Issue>) repo.findAll();
		return list;
	}

	// fetching issue by id
	public Issue getIssue(UUID id) {
		return repo.getOne(id);
	}

	// inserting issue
	public UUID addIssue(Issue c) {
		c.setCreatedBy(empservice.getEmployee(c.getCreatedBy().getId()));
		if (c.getProject() != null) {
			c.setProject(projservice.getProject(c.getProject().getId()));
		}
		if (c.getSprint() != null) {
			c.setSprint(sprintService.getSprint(c.getSprint().getId()));
		}
		List<Employee> l = new ArrayList<Employee>();
		c.getEmployees().forEach(item -> {
			l.add(empservice.getEmployee(item.getId()));
		});
		c.setEmployees(l);
		Date dtCreated = new Date();
		c.setDtCreated(dtCreated);
		repo.save(c);
		return c.getId();
	}

	// updating issue by id
	public void updateIssue(Issue obj, UUID id) {
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
	public void deleteIssueByID(UUID id) {
		repo.deleteById(id);
	}

	// patching/updating issue by id
	public void patchIssue(Issue obj, UUID id) {
		if (id == obj.getId()) {
			repo.save(obj);
		}
	}

	public void defaultIssues(Project p, Employee e, Date d) {

		/*
		 * Issue a1 = new Issue("Strategy", "Open", p, e, d, d); Issue a2 = new
		 * Issue("Design", "Open", p, e, d, d); Issue a3 = new Issue("Development",
		 * "Open", p, e, d, d); Issue a4 = new Issue("Testing", "Open", p, e, d, d);
		 * Issue a5 = new Issue("Deliverables", "Open", p, e, d, d); repo.save(a1);
		 * repo.save(a2); repo.save(a3); repo.save(a4); repo.save(a5);
		 */
	}
}
