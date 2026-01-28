package com.naresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.service.ScanJobService;

@RestController
@RequestMapping("/jobstatus")
public class ScanJobController {
	
	
	@Autowired
	ScanJobService scanJobService;
	
	@PostMapping("/createscanjob")
	public String createScanJob() {
			
		return null;
		
	}

}
