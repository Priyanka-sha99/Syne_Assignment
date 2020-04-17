package com.synechron.assignment.SyneAssignment.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HealthInsuranceCompanyNotFoundException extends RuntimeException {

	public HealthInsuranceCompanyNotFoundException(String message) {
		super(message);
	
	}

	
}
