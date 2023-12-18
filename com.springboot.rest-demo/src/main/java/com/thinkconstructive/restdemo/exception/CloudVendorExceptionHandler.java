package com.thinkconstructive.restdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CloudVendorExceptionHandler {
	
	@ExceptionHandler(value = {CloudVendorNotFoundException.class})
	public ResponseEntity<Object>  handleCloudVendorNotFoundException()
	{
		return new ResponseEntity<>("Requested cloud vendor does not exist",HttpStatus.NOT_FOUND);
	}

}
