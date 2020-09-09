package com.pmt.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Employee {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", columnDefinition = "BINARY(16)")
	private UUID id;

	private int empid;
	private String gender;
	private String firstName;
	private String lastName;
	private String officialEmail;
	private String personalEmail;
	private Long mob;
	private String roleType;

	@ManyToOne(cascade = CascadeType.ALL)
	private Department dept;

	private String designation;
	private Date joinDate;
	private Date endDate;
	private String username;
	private String password;
	private String skypeId;
	private String twitterId;
	private String linkedinId;
	private byte isactive;
	private byte isAgree;
	private byte isEmail;
	private String photo;
	private String aboutme;

	@Temporal(TemporalType.TIMESTAMP)
	private Date actDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date billingEndDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date billingStartDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtUpdated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtLastLogin;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtLastLogout;

	@ManyToOne(cascade = CascadeType.ALL)
	private Company company;

	@ManyToMany(targetEntity = Project.class, cascade = CascadeType.ALL)
	private List<Project> projects;

	public Employee() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOfficialEmail() {
		return officialEmail;
	}

	public void setOfficialEmail(String officialEmail) {
		this.officialEmail = officialEmail;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public Long getMob() {
		return mob;
	}

	public void setMob(Long mob) {
		this.mob = mob;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}

	public String getLinkedinId() {
		return linkedinId;
	}

	public void setLinkedinId(String linkedinId) {
		this.linkedinId = linkedinId;
	}

	public byte getIsactive() {
		return isactive;
	}

	public void setIsactive(byte isactive) {
		this.isactive = isactive;
	}

	public byte getIsAgree() {
		return isAgree;
	}

	public void setIsAgree(byte isAgree) {
		this.isAgree = isAgree;
	}

	public byte getIsEmail() {
		return isEmail;
	}

	public void setIsEmail(byte isEmail) {
		this.isEmail = isEmail;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}

	public Date getActDate() {
		return actDate;
	}

	public void setActDate(Date actDate) {
		this.actDate = actDate;
	}

	public Date getBillingEndDate() {
		return billingEndDate;
	}

	public void setBillingEndDate(Date billingEndDate) {
		this.billingEndDate = billingEndDate;
	}

	public Date getBillingStartDate() {
		return billingStartDate;
	}

	public void setBillingStartDate(Date billingStartDate) {
		this.billingStartDate = billingStartDate;
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

	public Date getDtLastLogin() {
		return dtLastLogin;
	}

	public void setDtLastLogin(Date dtLastLogin) {
		this.dtLastLogin = dtLastLogin;
	}

	public Date getDtLastLogout() {
		return dtLastLogout;
	}

	public void setDtLastLogout(Date dtLastLogout) {
		this.dtLastLogout = dtLastLogout;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Employee(int empid, String gender, String firstName, String lastName, String officialEmail,
			String personalEmail, Long mob, String roleType, Department dept, String designation, Date joinDate,
			Date endDate, String username, String password, String skypeId, String twitterId, String linkedinId,
			byte isactive, byte isAgree, byte isEmail, String photo, String aboutme, Date actDate, Date billingEndDate,
			Date billingStartDate, Date dtCreated, Date dtUpdated, Date dtLastLogin, Date dtLastLogout, Company company,
			List<Project> projects) {
		super();
		this.empid = empid;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.officialEmail = officialEmail;
		this.personalEmail = personalEmail;
		this.mob = mob;
		this.roleType = roleType;
		this.dept = dept;
		this.designation = designation;
		this.joinDate = joinDate;
		this.endDate = endDate;
		this.username = username;
		this.password = password;
		this.skypeId = skypeId;
		this.twitterId = twitterId;
		this.linkedinId = linkedinId;
		this.isactive = isactive;
		this.isAgree = isAgree;
		this.isEmail = isEmail;
		this.photo = photo;
		this.aboutme = aboutme;
		this.actDate = actDate;
		this.billingEndDate = billingEndDate;
		this.billingStartDate = billingStartDate;
		this.dtCreated = dtCreated;
		this.dtUpdated = dtUpdated;
		this.dtLastLogin = dtLastLogin;
		this.dtLastLogout = dtLastLogout;
		this.company = company;
		this.projects = projects;
	}

}