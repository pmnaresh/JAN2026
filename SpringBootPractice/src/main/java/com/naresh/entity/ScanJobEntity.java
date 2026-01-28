package com.naresh.entity;


import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="SCAN_JOB_STATUS")
@Data
public class ScanJobEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID")
	private int id;
	@Column(name="FACILITY_ID")
	private int facilityId;
	@Column(name="USERNAME")
	private String userName;
	@Column(name="JOB_ID")
	private int jobId;
	@Column(name="JOB_STATUS")
	private String jobStatus;
	@Column(name="CREATED_TIMESTAMP")
	private Timestamp createdTimestamp;
	@Column(name="UPDATED_TIMESTAMP")
	private Timestamp updatedTimeStamp;
}
