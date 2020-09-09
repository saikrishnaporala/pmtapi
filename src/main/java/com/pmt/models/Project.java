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
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	private int rate;
	private String ratebasedOn;
	private String priority;
	private String projDescr;
	private String skills;
	private String tools;
	private String status;
	private byte isactive;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtUpdated;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "empid")
	private Employee createdBy;

//	@JsonIgnore
//	@OneToMany(mappedBy = "proj", cascade = CascadeType.ALL)
//	private List<Sprint_dto> activity;
//
//	@JsonIgnore
//	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
//	private List<Issue> issues;

	@ManyToMany(targetEntity = Employee.class, mappedBy = "projects", cascade = CascadeType.ALL)
	private List<Employee> employees;

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

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getRatebasedOn() {
		return ratebasedOn;
	}

	public void setRatebasedOn(String ratebasedOn) {
		this.ratebasedOn = ratebasedOn;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getProjDescr() {
		return projDescr;
	}

	public void setProjDescr(String projDescr) {
		this.projDescr = projDescr;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getTools() {
		return tools;
	}

	public void setTools(String tools) {
		this.tools = tools;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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

	public Project(String projName, String client, Date startDate, Date endDate, int rate, String ratebasedOn,
			String priority, String projDescr, String skills, String tools, String status, byte isactive,
			Date dtCreated, Date dtUpdated, Company company, Employee createdBy, List<Employee> employees) {
		super();
		this.projName = projName;
		this.client = client;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rate = rate;
		this.ratebasedOn = ratebasedOn;
		this.priority = priority;
		this.projDescr = projDescr;
		this.skills = skills;
		this.tools = tools;
		this.status = status;
		this.isactive = isactive;
		this.dtCreated = dtCreated;
		this.dtUpdated = dtUpdated;
		this.company = company;
		this.createdBy = createdBy;
		this.employees = employees;
	}

}