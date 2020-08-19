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
	private UUID id;
	private String activityName;
	private String status;

	@ManyToOne
	@JoinColumn(name = "proj_id")
	private Project proj;

	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee actcreatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_created")
	private Date dtCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_updated")
	private Date dtUpdated;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getActcreatedBy() {
		return actcreatedBy;
	}

	public void setActcreatedBy(Employee actcreatedBy) {
		this.actcreatedBy = actcreatedBy;
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

	public Project getProj() {
		return proj;
	}

	public void setProj(Project proj) {
		this.proj = proj;
	}

	public Sprint(String activityName, String status, Project proj, Employee actcreatedBy, Date dtCreated,
			Date dtUpdated) {
		super();
		this.activityName = activityName;
		this.status = status;
		this.proj = proj;
		this.actcreatedBy = actcreatedBy;
		this.dtCreated = dtCreated;
		this.dtUpdated = dtUpdated;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", activityName=" + activityName + ", status=" + status + ", proj=" + proj
				+ ", createdBy=" + actcreatedBy + ", dtCreated=" + dtCreated + ", dtUpdated=" + dtUpdated + "]";
	}

}
