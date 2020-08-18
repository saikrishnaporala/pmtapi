package com.pmt.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class User {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", columnDefinition = "BINARY(16)")
	private UUID id;

	private String username;
	private String password;
	private byte isactive;
	private byte isAgree;
	private byte isEmail;
	private int activeDashboardTab;
	private byte deskNotify;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "act_date")
	private Date actDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "billing_end_date")
	private Date billingEndDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "billing_start_date")
	private Date billingStartDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_created")
	private Date dtCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_last_login")
	private Date dtLastLogin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_last_logout")
	private Date dtLastLogout;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_updated")
	private Date dtUpdated;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	private Employee emp;

	public User() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public int getActiveDashboardTab() {
		return activeDashboardTab;
	}

	public void setActiveDashboardTab(int activeDashboardTab) {
		this.activeDashboardTab = activeDashboardTab;
	}

	public byte getDeskNotify() {
		return deskNotify;
	}

	public void setDeskNotify(byte deskNotify) {
		this.deskNotify = deskNotify;
	}

	public Date getDtCreated() {
		return dtCreated;
	}

	public void setDtCreated(Date dtCreated) {
		this.dtCreated = dtCreated;
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

	public Date getDtUpdated() {
		return dtUpdated;
	}

	public void setDtUpdated(Date dtUpdated) {
		this.dtUpdated = dtUpdated;
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

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public User(UUID id, String username, String password, byte isactive, byte isAgree, byte isEmail,
			int activeDashboardTab, byte deskNotify, Date actDate, Date billingEndDate, Date billingStartDate,
			Date dtCreated, Date dtLastLogin, Date dtLastLogout, Date dtUpdated, Employee emp) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.isactive = isactive;
		this.isAgree = isAgree;
		this.isEmail = isEmail;
		this.activeDashboardTab = activeDashboardTab;
		this.deskNotify = deskNotify;
		this.actDate = actDate;
		this.billingEndDate = billingEndDate;
		this.billingStartDate = billingStartDate;
		this.dtCreated = dtCreated;
		this.dtLastLogin = dtLastLogin;
		this.dtLastLogout = dtLastLogout;
		this.dtUpdated = dtUpdated;
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", isactive=" + isactive
				+ ", isAgree=" + isAgree + ", isEmail=" + isEmail + ", activeDashboardTab=" + activeDashboardTab
				+ ", deskNotify=" + deskNotify + ", actDate=" + actDate + ", billingEndDate=" + billingEndDate
				+ ", billingStartDate=" + billingStartDate + ", dtCreated=" + dtCreated + ", dtLastLogin=" + dtLastLogin
				+ ", dtLastLogout=" + dtLastLogout + ", dtUpdated=" + dtUpdated + ", emp=" + emp + "]";
	}

}