package com.naresh.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "JOB_DETAILS")
@Entity
public class JobDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "JOB_ID")
	private int jobId;
	@Column(name = "JOB_STATUS")
	private String jobStatus;
	@Column(name="USERNAME")
	private String userName;
	@Column(name = "FACILITY_ID")
	private String facilityId;
	@Column(name = "FLAG_STATUS")
	private boolean flagStatus;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimestamp;
	@Column(name = "UPDATED_TIMESTAMP")
	private Timestamp updatedTimestamp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	public boolean isFlagStatus() {
		return flagStatus;
	}
	public void setFlagStatus(boolean flagStatus) {
		this.flagStatus = flagStatus;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	public Timestamp getUpdatedTimestamp() {
		return updatedTimestamp;
	}
	public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

}
