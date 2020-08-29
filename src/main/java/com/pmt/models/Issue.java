package com.pmt.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name = "id", columnDefinition = "BINARY(16)")
	private UUID id;

	private String issueSubject;

	private String issueType;

	@ManyToOne
	@JoinColumn(name = "sprint_id")
	private Sprint sprint; // object

	@ManyToOne
	@JoinColumn(name = "proj_id")
	private Project project; // object

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date")
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date")
	private Date endDate;

	private String priority;
	private String issueDescr;
	private String status;
	private byte isactive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_created")
	private Date dtCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_updated")
	private Date dtUpdated;

	private String review;
	private String comments;

	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee createdBy;

	@ManyToMany(targetEntity = Employee.class, mappedBy = "tasks", cascade = { CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH })
	private List<Employee> employees;

	public Issue() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getIssueSubject() {
		return issueSubject;
	}

	public void setIssueSubject(String issueSubject) {
		this.issueSubject = issueSubject;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getIssueDescr() {
		return issueDescr;
	}

	public void setIssueDescr(String issueDescr) {
		this.issueDescr = issueDescr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte getIsactive() {
		return isactive;
	}

	public void setIsactive(byte isactive) {
		this.isactive = isactive;
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

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Employee getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Employee createdBy) {
		this.createdBy = createdBy;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Issue(String issueSubject, String issueType, Sprint sprint, Project project, Date startDate, Date endDate,
			String priority, String issueDescr, String status, byte isactive, Date dtCreated, Date dtUpdated,
			String review, String comments, Employee createdBy, List<Employee> employees) {
		super();
		this.issueSubject = issueSubject;
		this.issueType = issueType;
		this.sprint = sprint;
		this.project = project;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.issueDescr = issueDescr;
		this.status = status;
		this.isactive = isactive;
		this.dtCreated = dtCreated;
		this.dtUpdated = dtUpdated;
		this.review = review;
		this.comments = comments;
		this.createdBy = createdBy;
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Issue [id=" + id + ", issueSubject=" + issueSubject + ", issueType=" + issueType + ", sprint=" + sprint
				+ ", project=" + project + ", startDate=" + startDate + ", endDate=" + endDate + ", priority="
				+ priority + ", issueDescr=" + issueDescr + ", status=" + status + ", isactive=" + isactive
				+ ", dtCreated=" + dtCreated + ", dtUpdated=" + dtUpdated + ", review=" + review + ", comments="
				+ comments + ", createdBy=" + createdBy + ", employees=" + employees + "]";
	}

}