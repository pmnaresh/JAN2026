package com.naresh.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.entity.JobDetails;
import com.naresh.model.Response;
import com.naresh.repository.JobDetailsRepository;

@Service
public class JobDetailsService {

	@Autowired
	JobDetailsRepository jobDetailsRepository;

	private static final Logger logger = LoggerFactory.getLogger(JobDetailsService.class);
	Response response;

	public Response createJobDetails(JobDetails jobDetails) {
		response = new Response();
		logger.info("Ëntered in createJobDetails method in service layer-->" + jobDetails);

		jobDetails.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
		jobDetails.setFlagStatus(false);

		logger.info("updated jobDetails object -->" + jobDetails);
		try {
			jobDetailsRepository.save(jobDetails);
			response.setStatuscode(200);
			response.setSuccessMessage("Record saved successfully in the db");

		} catch (Exception e) {
			logger.error("Exception occured while saving record in the db" + e.getMessage());
			response.setStatuscode(500);
			response.setFailureMessage("failed while saving record in the db");
		}
		return response;
	}

	public List<JobDetails> getAllJobDetails() {
		List<JobDetails> listOfJobDetails = null;
		try {
			listOfJobDetails = jobDetailsRepository.findAll();
			logger.info("All records from job details table -->" + listOfJobDetails);
		} catch (Exception e) {
			logger.info("Ëxception occured while fetching details from db " + e.getMessage());
		}
		return listOfJobDetails;
	}

	public List<JobDetails> getAllJobDetailsByCurrentDate() {
		List<JobDetails> listOfJobDetails = null;

		try {
			LocalDate localDate = LocalDate.now();
			logger.info("localDate is -->" + localDate);
			LocalDateTime today = localDate.atStartOfDay();
			logger.info("today date is -->" + today);
			LocalDateTime tommorrow = localDate.plusDays(1).atStartOfDay();
			logger.info("tomorrow date is -->" + tommorrow);
			listOfJobDetails = jobDetailsRepository.findByCreatedDate(today, tommorrow);
			logger.info("Total records for day today is -->" + listOfJobDetails);

		} catch (Exception e) {
			logger.error("Exception occured while fetching records fromdb in getAllJobDetailsByCurrentDate method "
					+ e.getMessage());
		}
		return listOfJobDetails;
	}

	public void updateDetailsService(String facilityId, int jobId) {
		response = new Response();
		List<JobDetails> listOfJobDetails = jobDetailsRepository.findByFacilityIdandJobId(facilityId, jobId);
		
		logger.info("List of records for facilityId :"+facilityId +" and jobId :"+jobId+" are :"+listOfJobDetails);

		if (!listOfJobDetails.isEmpty()) {
			for (JobDetails jobDetails : listOfJobDetails) {
				
				if(jobDetails.getJobStatus().equalsIgnoreCase("Started")) {
					logger.info("when jobstatus is Started");
					jobDetails.setJobStatus("inprogress");
					jobDetails.setUpdatedTimestamp(new Timestamp(System.currentTimeMillis()));
					jobDetailsRepository.save(jobDetails);
					logger.info("status updated to in progress and saved in the db");
				}else if(jobDetails.getJobStatus().equalsIgnoreCase("inprogress")) {
					logger.info("when jobstatus is inprogress");
					jobDetails.setJobStatus("completed");
					jobDetails.setFlagStatus(true);
					jobDetails.setUpdatedTimestamp(new Timestamp(System.currentTimeMillis()));
					jobDetailsRepository.save(jobDetails);
					logger.info("status updated to completed and saved in the db");
				}

			}
		}else {
			response.setStatuscode(200);
			response.setSuccessMessage("There are no records found with the given details please check details you provided!!!!");
		}

	}

}
