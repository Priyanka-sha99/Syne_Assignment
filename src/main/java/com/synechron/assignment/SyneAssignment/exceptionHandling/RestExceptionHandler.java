package com.synechron.assignment.SyneAssignment.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class RestExceptionHandler {
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponseBean> handleException(ObjectNotFoundException exe)
	{
		ErrorResponseBean error = new ErrorResponseBean();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exe.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorResponseBean>(error, HttpStatus.NOT_FOUND);
	}
	//to handle all type of exceptions like string type use generic exception
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponseBean> handleExp(Exception exe)
	{
		ErrorResponseBean error = new ErrorResponseBean();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exe.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorResponseBean>(error, HttpStatus.BAD_REQUEST);
	}

}
