package com.pmt.models.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 * The persistent class for the users database table.
 * 
 * @param <Team>
 * 
 */

public class Employee_dto {
	private UUID id;
	private int empid;
	private String gender;
	private String firstName;
	private String lastName;
	private String officialEmail;
	private String personalEmail;
	private Long mob;
	private String roleType;
	private UUID dept;
	private String designation;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joinDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	private String username;
	private String password;
	private String skypeId;
	private String twitterId;
	private String linkedinId;
	private String isactive;
	private String isAgree;
	private String isEmail;
	private MultipartFile photo;
	private String aboutme;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date actDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date billingEndDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date billingStartDate;
	private Date dtCreated;
	private Date dtUpdated;
	private Date dtLastLogin;
	private Date dtLastLogout;
	private UUID company;
	private List<UUID> projects;

	public Employee_dto() {
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

	public UUID getDept() {
		return dept;
	}

	public void setDept(UUID dept) {
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

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public String getIsAgree() {
		return isAgree;
	}

	public void setIsAgree(String isAgree) {
		this.isAgree = isAgree;
	}

	public String getIsEmail() {
		return isEmail;
	}

	public void setIsEmail(String isEmail) {
		this.isEmail = isEmail;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
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

	public UUID getCompany() {
		return company;
	}

	public void setCompany(UUID company) {
		this.company = company;
	}

	public List<UUID> getProjects() {
		return projects;
	}

	public void setProjects(List<UUID> projects) {
		this.projects = projects;
	}

}