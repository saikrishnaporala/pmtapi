package com.pmt.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the company_users database table.
 * 
 */
@Entity
public class CompanyUsers implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "act_date")
	private Date actDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "billing_end_date")
	private Date billingEndDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "billing_start_date")
	private Date billingStartDate;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@Column(name = "company_uniq_id")
	private String companyUniqId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name = "est_billing_amt")
	private float estBillingAmt;

	@Column(name = "is_active")
	private byte isActive;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	@OneToOne(cascade = CascadeType.ALL)
	private User userId;

	@Column(name = "user_type")
	private int userType;

	public CompanyUsers() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getCompanyUniqId() {
		return companyUniqId;
	}

	public void setCompanyUniqId(String companyUniqId) {
		this.companyUniqId = companyUniqId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public float getEstBillingAmt() {
		return estBillingAmt;
	}

	public void setEstBillingAmt(float estBillingAmt) {
		this.estBillingAmt = estBillingAmt;
	}

	public byte getIsActive() {
		return isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

}