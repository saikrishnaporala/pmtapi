package com.pmt.models;

import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(columnDefinition = "BINARY(16)")
	private UUID taskid;

	private String taskName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sprint_id")
	private Sprint taskSprint; // object

	private String taskType;

	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task taskParent; // object

	@Temporal(TemporalType.TIMESTAMP)
	private Date taskStartDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date taskEndDate;

	private String taskPriority;
	private String taskDescr;
	private String taskStatus;
	private String taskIsactive;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtUpdated;

	private String taskReview;
	private String taskComments;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	private Employee taskCreatedBy;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "proj_id")
	private Project taskProj;

	@JsonIgnore
	@OneToMany(mappedBy = "taskParent", cascade = CascadeType.ALL)
	private List<Task> tasks;

	@ManyToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
	private Set<Employee> taskEmployees;

	public Task() {
	}

	public UUID getTaskid() {
		return taskid;
	}

	public void setId(UUID taskid) {
		this.taskid = taskid;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Sprint getTaskSprint() {
		return taskSprint;
	}

	public void setTaskSprint(Sprint taskSprint) {
		this.taskSprint = taskSprint;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public Task getTaskParent() {
		return taskParent;
	}

	public void setTaskParent(Task taskParent) {
		this.taskParent = taskParent;
	}

	public Date getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public Date getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	public String getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	public String getTaskDescr() {
		return taskDescr;
	}

	public void setTaskDescr(String taskDescr) {
		this.taskDescr = taskDescr;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskIsactive() {
		return taskIsactive;
	}

	public void setTaskIsactive(String taskIsactive) {
		this.taskIsactive = taskIsactive;
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

	public String getTaskReview() {
		return taskReview;
	}

	public void setTaskReview(String taskReview) {
		this.taskReview = taskReview;
	}

	public String getTaskComments() {
		return taskComments;
	}

	public void setTaskComments(String taskComments) {
		this.taskComments = taskComments;
	}

	public Employee getTaskCreatedBy() {
		return taskCreatedBy;
	}

	public void setTaskCreatedBy(Employee taskCreatedBy) {
		this.taskCreatedBy = taskCreatedBy;
	}

	public Project getTaskProj() {
		return taskProj;
	}

	public void setTaskProj(Project taskProj) {
		this.taskProj = taskProj;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Set<Employee> getTaskEmployees() {
		return taskEmployees;
	}

	public void setTaskEmployees(Set<Employee> taskEmployees) {
		this.taskEmployees = taskEmployees;
	}

	public void setTaskid(UUID taskid) {
		this.taskid = taskid;
	}
}