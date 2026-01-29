
package com.naresh.model;

import java.util.List;

import com.naresh.entity.JobDetails;

public class Response {
	
	private int statuscode;
	private String successMessage;
	private String failureMessage; 
	private List<JobDetails> ListOfJobDetails;
	
	public List<JobDetails> getListOfJobDetails() {
		return ListOfJobDetails;
	}
	public void setListOfJobDetails(List<JobDetails> listOfJobDetails) {
		ListOfJobDetails = listOfJobDetails;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getFailureMessage() {
		return failureMessage;
	}
	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}
}
