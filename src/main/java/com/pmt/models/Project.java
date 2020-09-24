package com.pmt.models;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
public class Project {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", columnDefinition = "BINARY(16)")
	private UUID id;

	private String projName;
	private String client; // object

	@Temporal(TemporalType.TIMESTAMP)
	private Date projStartDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date projEndDate;
	private String projPriority;
	private String projDescr;
	private String projSkills;
	private String projTools;
	private String projStatus;
	private String projIsactive;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtUpdated;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "company")
	private Company company;

	@ManyToOne
	@JoinColumn(name = "empid")
	private Employee projCreatedBy;

	@JsonIgnore
	@OneToMany(mappedBy = "sprintProj", orphanRemoval = true)
	private Set<Sprint> sprint;

	@JsonIgnore
	@OneToMany(mappedBy = "taskProj", orphanRemoval = true)
	private List<Task> task;

	@JsonIgnore
	@OneToMany(mappedBy = "issueProj", orphanRemoval = true)
	private List<Issue> issues;

	@ManyToMany(mappedBy = "projects")
	private Set<Employee> employees;

	public Project() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Date getProjStartDate() {
		return projStartDate;
	}

	public void setProjStartDate(Date projStartDate) {
		this.projStartDate = projStartDate;
	}

	public Date getProjEndDate() {
		return projEndDate;
	}

	public void setProjEndDate(Date projEndDate) {
		this.projEndDate = projEndDate;
	}

	public String getProjPriority() {
		return projPriority;
	}

	public void setProjPriority(String projPriority) {
		this.projPriority = projPriority;
	}

	public String getProjDescr() {
		return projDescr;
	}

	public void setProjDescr(String projDescr) {
		this.projDescr = projDescr;
	}

	public String getProjSkills() {
		return projSkills;
	}

	public void setProjSkills(String projSkills) {
		this.projSkills = projSkills;
	}

	public String getProjTools() {
		return projTools;
	}

	public void setProjTools(String projTools) {
		this.projTools = projTools;
	}

	public String getProjStatus() {
		return projStatus;
	}

	public void setProjStatus(String projStatus) {
		this.projStatus = projStatus;
	}

	public String getProjIsactive() {
		return projIsactive;
	}

	public void setProjIsactive(String projIsactive) {
		this.projIsactive = projIsactive;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Employee getProjCreatedBy() {
		return projCreatedBy;
	}

	public void setProjCreatedBy(Employee projCreatedBy) {
		this.projCreatedBy = projCreatedBy;
	}

	public Set<Sprint> getSprint() {
		return sprint;
	}

	public void setSprint(Set<Sprint> sprint) {
		this.sprint = sprint;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}