package com.naresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.entity.JobDetails;
import com.naresh.service.JobDetailsService;

@RestController
@RequestMapping("/jobdetails")
public class JobDetailsController {
	
	@Autowired
	JobDetailsService jobDetailsService;
	
	@PostMapping("/createjob")
	public String createJobDetails(@RequestBody JobDetails jobDetails) {
		
		
		return null;
	}
	
	

}
