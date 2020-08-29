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
	private String sprintName;
	private String status;
	private int seq;

	@ManyToOne
	@JoinColumn(name = "proj_id")
	private Project proj;

	public Sprint() {
	}

	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee sprintcreatedBy;

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

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public Project getProj() {
		return proj;
	}

	public void setProj(Project proj) {
		this.proj = proj;
	}

	public Employee getSprintcreatedBy() {
		return sprintcreatedBy;
	}

	public void setSprintcreatedBy(Employee sprintcreatedBy) {
		this.sprintcreatedBy = sprintcreatedBy;
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

	public Sprint(String sprintName, String status, int seq, Project proj, Employee sprintcreatedBy, Date dtCreated,
			Date dtUpdated) {
		super();
		this.sprintName = sprintName;
		this.status = status;
		this.seq = seq;
		this.proj = proj;
		this.sprintcreatedBy = sprintcreatedBy;
		this.dtCreated = dtCreated;
		this.dtUpdated = dtUpdated;
	}

}
