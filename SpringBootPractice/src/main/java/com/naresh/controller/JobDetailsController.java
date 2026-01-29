package com.naresh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.entity.JobDetails;
import com.naresh.model.Response;
import com.naresh.service.JobDetailsService;
import java.util.List;

@RestController
@RequestMapping("/jobdetails")
public class JobDetailsController {

	private static final Logger logger = LoggerFactory.getLogger(JobDetailsController.class);

	@Autowired
	JobDetailsService jobDetailsService;

	@PostMapping("/createjob")
	public Response createJobDetails(@RequestBody JobDetails jobDetails) {
		logger.info("Request reached to createJobDetails in the jobDetailsController-->" + jobDetails);
		return jobDetailsService.createJobDetails(jobDetails);
	}

	@PutMapping("/updateJob/{facilityID}/{jobId}")
	public void updatejobDetails(@PathVariable String facilityID, @PathVariable int jobId) {
		logger.info("Job Details will be updated to  existing user where facilityID= " + facilityID + " jobId= " + jobId );
		jobDetailsService.updateDetailsService(facilityID, jobId);
	}

	@GetMapping("/findAllJobDetails")
	public List<JobDetails> getAllJobDetails() {
		logger.info("Fetching all job details for the day");
		return jobDetailsService.getAllJobDetails();
	}

	@GetMapping("/findAllJobDetailsOfCurrentDate")
	public List<JobDetails> getAllJobDetailsOfCurrentDate() {
		logger.info("Fetching all job details for the day");
		return jobDetailsService.getAllJobDetailsByCurrentDate();
	}
 
}
