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

}
