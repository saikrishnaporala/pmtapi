package com.pmt.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Task {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", columnDefinition = "BINARY(16)")
	private UUID id;

	private String taskName;

	@ManyToOne
	@JoinColumn(name = "sprint_id")
	private Sprint sprint; // object

	private String taskType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date")
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date")
	private Date endDate;

	private String priority;
	private String taskDescr;
	private String status;
	private byte isactive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_created")
	private Date dtCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_updated")
	private Date dtUpdated;

	private String review;
	private String revision;
	private String comments;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	private Employee createdBy;

	@ManyToOne
	@JoinColumn(name = "proj_id")
	private Project proj;
	/*
	 * @ManyToMany(targetEntity = Employee.class, mappedBy = "tasks", cascade = {
	 * CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
	 * CascadeType.REFRESH }) private List<Employee> employees;
	 */

	public Task() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
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

	public String getTaskDescr() {
		return taskDescr;
	}

	public void setTaskDescr(String taskDescr) {
		this.taskDescr = taskDescr;
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

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
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

	public Project getProj() {
		return proj;
	}

	public void setProj(Project proj) {
		this.proj = proj;
	}

	public Task(String taskName, Sprint sprint, String taskType, Date startDate, Date endDate, String priority,
			String taskDescr, String status, byte isactive, Date dtCreated, Date dtUpdated, String review,
			String revision, String comments, Employee createdBy, Project proj) {
		super();
		this.taskName = taskName;
		this.sprint = sprint;
		this.taskType = taskType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.taskDescr = taskDescr;
		this.status = status;
		this.isactive = isactive;
		this.dtCreated = dtCreated;
		this.dtUpdated = dtUpdated;
		this.review = review;
		this.revision = revision;
		this.comments = comments;
		this.createdBy = createdBy;
		this.proj = proj;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskName=" + taskName + ", sprint=" + sprint + ", taskType=" + taskType
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", priority=" + priority + ", taskDescr="
				+ taskDescr + ", status=" + status + ", isactive=" + isactive + ", dtCreated=" + dtCreated
				+ ", dtUpdated=" + dtUpdated + ", review=" + review + ", revision=" + revision + ", comments="
				+ comments + ", createdBy=" + createdBy + ", proj=" + proj + "]";
	}

	/*
	 * public List<Employee> getEmployees() { return employees; }
	 * 
	 * public void setEmployees(List<Employee> employees) { this.employees =
	 * employees; }
	 */

}