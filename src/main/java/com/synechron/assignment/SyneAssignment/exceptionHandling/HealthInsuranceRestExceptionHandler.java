package com.synechron.assignment.SyneAssignment.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class HealthInsuranceRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<HealthInsuranceErrorResponse> handleException(HealthInsuranceCompanyNotFoundException exe)
	{
		HealthInsuranceErrorResponse error = new HealthInsuranceErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exe.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<HealthInsuranceErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	//to handle all type of exceptions like string type use generic exception
	
	@ExceptionHandler
	public ResponseEntity<HealthInsuranceErrorResponse> handleExp(Exception exe)
	{
		HealthInsuranceErrorResponse error = new HealthInsuranceErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exe.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<HealthInsuranceErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

}
