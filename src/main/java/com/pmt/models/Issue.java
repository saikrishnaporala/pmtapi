package com.pmt.models;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the users database table.
 * 
 * @param <Team>
 * 
 */
@Entity
public class Issue {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "issueid", columnDefinition = "BINARY(16)")
	private UUID issueid;

	private String issueSubject;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "task_id")
	private Task issueTask; // object

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "sprint_id")
	private Sprint issueSprint; // object

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "proj_id")
	private Project issueProj; // object

	@Temporal(TemporalType.TIMESTAMP)
	private Date issueStartDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date issueEndDate;

	private String issuePriority;
	private String issueDescr;
	private String issueStatus;
	private String issueIsactive;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtUpdated;

	private String issueReview;
	private String issueComments;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	private Employee issueCreatedBy;

	@ManyToMany(mappedBy = "issues", cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	private Set<Employee> issueEmployees;

	public UUID getIssueid() {
		return issueid;
	}

	public void setIssueid(UUID issueid) {
		this.issueid = issueid;
	}

	public String getIssueSubject() {
		return issueSubject;
	}

	public void setIssueSubject(String issueSubject) {
		this.issueSubject = issueSubject;
	}

	public Task getIssueTask() {
		return issueTask;
	}

	public void setIssueTask(Task task) {
		this.issueTask = task;
	}

	public Sprint getIssueSprint() {
		return issueSprint;
	}

	public void setIssueSprint(Sprint issueSprint) {
		this.issueSprint = issueSprint;
	}

	public Project getIssueProj() {
		return issueProj;
	}

	public void setIssueProj(Project issueProj) {
		this.issueProj = issueProj;
	}

	public Date getIssueStartDate() {
		return issueStartDate;
	}

	public void setIssueStartDate(Date issueStartDate) {
		this.issueStartDate = issueStartDate;
	}

	public Date getIssueEndDate() {
		return issueEndDate;
	}

	public void setIssueEndDate(Date issueEndDate) {
		this.issueEndDate = issueEndDate;
	}

	public String getIssuePriority() {
		return issuePriority;
	}

	public void setIssuePriority(String issuePriority) {
		this.issuePriority = issuePriority;
	}

	public String getIssueDescr() {
		return issueDescr;
	}

	public void setIssueDescr(String issueDescr) {
		this.issueDescr = issueDescr;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public String getIssueIsactive() {
		return issueIsactive;
	}

	public void setIssueIsactive(String issueIsactive) {
		this.issueIsactive = issueIsactive;
	}

	public Date getDtCreated() {
		return dtCreated;
	}

	public void setDtCreated(Date dtCreated) {
		this.dtCreated = dtCreated;
	}

	public Date getDtUpdated() {
		return dtUpdated;
	}

	public void setDtUpdated(Date dtUpdated) {
		this.dtUpdated = dtUpdated;
	}

	public String getIssueReview() {
		return issueReview;
	}

	public void setIssueReview(String issueReview) {
		this.issueReview = issueReview;
	}

	public String getIssueComments() {
		return issueComments;
	}

	public void setIssueComments(String issueComments) {
		this.issueComments = issueComments;
	}

	public Employee getIssueCreatedBy() {
		return issueCreatedBy;
	}

	public void setIssueCreatedBy(Employee issueCreatedBy) {
		this.issueCreatedBy = issueCreatedBy;
	}

	public Set<Employee> getIssueEmployees() {
		return issueEmployees;
	}

	public void setIssueEmployees(Set<Employee> issueEmployees) {
		this.issueEmployees = issueEmployees;
	}

}