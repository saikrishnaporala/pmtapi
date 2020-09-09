package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Issue;
import com.pmt.models.Project;
import com.pmt.models.dto.Issue_dto;
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
	public UUID cuIssue(Issue_dto obj) {
		Issue issue = mappingDTO(obj);
		if (obj.getId() == null) {
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
		return issue.getId();
		/*
		 * List<Employee> l = new ArrayList<Employee>(); c.getEmployees().forEach(item
		 * -> { l.add(empservice.getEmployee(item.getId())); }); c.setEmployees(l);
		 */
	}

	private Issue mappingDTO(Issue_dto obj) {
		Issue c1 = new Issue();
		if (obj.getId() != null) {
			c1 = this.getIssue(obj.getId());
		}
		c1.setIssueSubject(obj.getIssueSubject());
		c1.setIssueType(obj.getIssueType());
		c1.setProj(projservice.getProject(obj.getProj()));
		c1.setStartDate(obj.getStartDate());
		c1.setEndDate(obj.getEndDate());
		c1.setPriority(obj.getPriority());
		c1.setIssueDescr(obj.getIssueDescr());
		c1.setStatus(obj.getStatus());
		c1.setIsactive(obj.getIsactive());
		c1.setReview(obj.getReview());
		c1.setComments(obj.getComments());
		c1.setCreatedBy(empservice.getEmployee(obj.getCreatedBy()));
		return c1;
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

	public List<Issue> getAllIssuesByPID(UUID id) {
		System.out.println("pid: " + id);
		Project proj = new Project();
		proj.setId(id);
		List<Issue> list = (List<Issue>) repo.findByProj(proj);
		// list.sort(Comparator.comparing(Sprint_dto::getSeq));
		return list;
	}
}
