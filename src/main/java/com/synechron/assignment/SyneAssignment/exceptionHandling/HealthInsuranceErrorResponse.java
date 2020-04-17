package com.synechron.assignment.SyneAssignment.exceptionHandling;

public class HealthInsuranceErrorResponse {
	
	private int Status;
	private String message;
	private long timestamp;
	
	public HealthInsuranceErrorResponse() {
		
	}

	public HealthInsuranceErrorResponse(int status, String message, long timestamp) {
		super();
		Status = status;
		this.message = message;
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
