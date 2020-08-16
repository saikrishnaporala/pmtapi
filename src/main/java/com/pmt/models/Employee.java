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
import javax.persistence.OneToOne;
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
public class Employee {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", columnDefinition = "BINARY(16)")
	private UUID id;

	private int empid;
	private String firstName;
	private String lastName;
	private String officialEmail;
	private String personalEmail;
	private Long mob;
	private int roleType;
	private String skypeId;
	private String twitterId;
	private String linkedinId;
	private byte isactive;
	private byte isAgree;
	private byte isEmail;
	private String photo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_created")
	private Date dtCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_updated")
	private Date dtUpdated;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;

	@JsonIgnore
	@OneToOne(mappedBy = "emp")
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_id")
	private Department dept;

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

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public int getRoleType() {
		return roleType;
	}

	public void setRoleType(int roleType) {
		this.roleType = roleType;
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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team1) {
		team = team1;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empid=" + empid + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", officialEmail=" + officialEmail + ", personalEmail=" + personalEmail + ", mob=" + mob + ", dept="
				+ dept + ", roleType=" + roleType + ", skypeId=" + skypeId + ", twitterId=" + twitterId
				+ ", linkedinId=" + linkedinId + ", isactive=" + isactive + ", isAgree=" + isAgree + ", isEmail="
				+ isEmail + ", photo=" + photo + ", dtCreated=" + dtCreated + ", dtUpdated=" + dtUpdated + ", company="
				+ company + ", team=" + team + ", user=" + user + "]";
	}

	public Employee(UUID id, int empid, String firstName, String lastName, String officialEmail, String personalEmail,
			Long mob, Department dept, int roleType, String skypeId, String twitterId, String linkedinId, byte isactive,
			byte isAgree, byte isEmail, String photo, Date dtCreated, Date dtUpdated, Company company, Team team,
			User user) {
		super();
		this.id = id;
		this.empid = empid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.officialEmail = officialEmail;
		this.personalEmail = personalEmail;
		this.mob = mob;
		this.dept = dept;
		this.roleType = roleType;
		this.skypeId = skypeId;
		this.twitterId = twitterId;
		this.linkedinId = linkedinId;
		this.isactive = isactive;
		this.isAgree = isAgree;
		this.isEmail = isEmail;
		this.photo = photo;
		this.dtCreated = dtCreated;
		this.dtUpdated = dtUpdated;
		this.company = company;
		this.team = team;
		this.user = user;
	}

}