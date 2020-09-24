package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Employee;
import com.pmt.models.Issue;
import com.pmt.models.Project;
import com.pmt.models.dto.Issue_dto;
import com.pmt.repos.EmployeeRepo;
import com.pmt.repos.IssuesRepo;

@Service
public class IssueService {

	@Autowired
	private IssuesRepo repo;

	@Autowired
	private EmployeeRepo erepo;

	@Autowired
	private EmployeeService empservice;

	@Autowired
	private ProjectService projservice;

	@Autowired
	private SprintService sprintService;

	@Autowired
	private TaskService taskService;

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
	public UUID cuIssue(Issue_dto obj) {
		Issue issue = mappingDTO(obj);
		if (obj.getIssueid() == null) {
			issue.setDtCreated(new Date());
		} else {
			issue.setDtUpdated(new Date());
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
		issue = repo.save(issue);
//		for (UUID emp : obj.getIssueEmployees()) {
//			Employee e = erepo.getOne(emp);
//			System.out.println("employee : " + e.getId());
//			Set<Issue> s = e.getIssues();
//			s.add(issue);
//			erepo.save(e);
//		}
		return issue.getIssueid();
	}

	private Issue mappingDTO(Issue_dto obj) {
		Issue c1 = new Issue();
		if (obj.getIssueid() != null) {
			c1 = this.getIssue(obj.getIssueid());
		}
		c1.setIssueSubject(obj.getIssueSubject());
		c1.setIssueTask(taskService.getTask(obj.getIssueTask()));
		c1.setIssueSprint(sprintService.getSprint(obj.getIssueSprint()));
		c1.setIssueProj(projservice.getProject(obj.getIssueProj()));
		c1.setIssueStartDate(obj.getIssueStartDate());
		c1.setIssueEndDate(obj.getIssueEndDate());
		c1.setIssuePriority(obj.getIssuePriority());
		c1.setIssueDescr(obj.getIssueDescr());
		c1.setIssueStatus(obj.getIssueStatus());
		c1.setIssueIsactive(obj.getissueIsactive());
		c1.setIssueReview(obj.getIssueReview());
		c1.setIssueComments(obj.getIssueComments());
		c1.setIssueCreatedBy(empservice.getEmployee(obj.getIssueCreatedBy()));
		Set<Employee> employees = obj.getIssueEmployees().stream().map(u -> erepo.getOne(u))
				.collect(Collectors.toSet());
		c1.setIssueEmployees(employees);
		return c1;
	}

	// updating issue by id
	public void updateIssue(Issue obj, UUID id) {
		if (id == obj.getIssueid()) {
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
		Issue i = repo.getOne(id);
//		for (Employee emp : i.getIssueEmployees()) {
//			Employee e = erepo.getOne(emp.getId());
//			System.out.println("employee : " + e.getId());
//			Set<Issue> s = e.getIssues();
//			s.remove(i);
//			e.setIssues(s);
//			erepo.save(e);
//		}
		repo.deleteById(id);
	}

	// patching/updating issue by id
	public void patchIssue(Issue obj, UUID id) {
		if (id == obj.getIssueid()) {
			repo.save(obj);
		}
	}

	public List<Issue> getAllIssuesByPID(UUID id) {
		System.out.println("pid: " + id);
		Project proj = new Project();
		proj.setId(id);
		List<Issue> list = (List<Issue>) repo.findByIssueProj(proj);
		// list.sort(Comparator.comparing(Sprint_dto::getSeq));
		return list;
	}
}
