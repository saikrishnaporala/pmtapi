package com.pmt.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Sprint {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", columnDefinition = "BINARY(16)")
	private UUID sprintid;
	private String sprintName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date sprintStartDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date sprintEndDate;

	private String sprintStatus;

	@ManyToOne
	@JoinColumn(name = "proj_id")
	private Project sprintProj;

	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee sprintCreatedBy;

	private String sprintIsactive;
	private String sprintDescr;
	@Temporal(TemporalType.TIMESTAMP)
	private Date sprintDtCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date sprintDtUpdated;

	public Sprint() {
	}

	public UUID getSprintid() {
		return sprintid;
	}

	public void setSprintid(UUID sprintid) {
		this.sprintid = sprintid;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public Date getSprintStartDate() {
		return sprintStartDate;
	}

	public void setSprintStartDate(Date sprintStartDate) {
		this.sprintStartDate = sprintStartDate;
	}

	public Date getSprintEndDate() {
		return sprintEndDate;
	}

	public void setSprintEndDate(Date sprintEndDate) {
		this.sprintEndDate = sprintEndDate;
	}

	public String getSprintStatus() {
		return sprintStatus;
	}

	public void setSprintStatus(String sprintStatus) {
		this.sprintStatus = sprintStatus;
	}

	public Project getSprintProj() {
		return sprintProj;
	}

	public void setSprintProj(Project sprintProj) {
		this.sprintProj = sprintProj;
	}

	public Employee getSprintCreatedBy() {
		return sprintCreatedBy;
	}

	public void setSprintCreatedBy(Employee sprintCreatedBy) {
		this.sprintCreatedBy = sprintCreatedBy;
	}

	public String getSprintIsactive() {
		return sprintIsactive;
	}

	public void setSprintIsactive(String sprintIsactive) {
		this.sprintIsactive = sprintIsactive;
	}

	public String getSprintDescr() {
		return sprintDescr;
	}

	public void setSprintDescr(String sprintDescr) {
		this.sprintDescr = sprintDescr;
	}

	public Date getSprintDtCreated() {
		return sprintDtCreated;
	}

	public void setSprintDtCreated(Date sprintDtCreated) {
		this.sprintDtCreated = sprintDtCreated;
	}

	public Date getSprintDtUpdated() {
		return sprintDtUpdated;
	}

	public void setSprintDtUpdated(Date sprintDtUpdated) {
		this.sprintDtUpdated = sprintDtUpdated;
	}

	public Sprint(UUID sprintid, String sprintName, Date sprintStartDate, Date sprintEndDate, String sprintStatus,
			Project sprintProj, Employee sprintCreatedBy, String sprintIsactive, String sprintDescr,
			Date sprintDtCreated, Date sprintDtUpdated) {
		super();
		this.sprintid = sprintid;
		this.sprintName = sprintName;
		this.sprintStartDate = sprintStartDate;
		this.sprintEndDate = sprintEndDate;
		this.sprintStatus = sprintStatus;
		this.sprintProj = sprintProj;
		this.sprintCreatedBy = sprintCreatedBy;
		this.sprintIsactive = sprintIsactive;
		this.sprintDescr = sprintDescr;
		this.sprintDtCreated = sprintDtCreated;
		this.sprintDtUpdated = sprintDtUpdated;
	}

	@Override
	public String toString() {
		return "Sprint [sprintid=" + sprintid + ", sprintName=" + sprintName + ", sprintStartDate=" + sprintStartDate
				+ ", sprintEndDate=" + sprintEndDate + ", sprintStatus=" + sprintStatus + ", sprintProj=" + sprintProj
				+ ", sprintCreatedBy=" + sprintCreatedBy + ", sprintIsactive=" + sprintIsactive + ", sprintDescr="
				+ sprintDescr + ", sprintDtCreated=" + sprintDtCreated + ", sprintDtUpdated=" + sprintDtUpdated + "]";
	}

}
