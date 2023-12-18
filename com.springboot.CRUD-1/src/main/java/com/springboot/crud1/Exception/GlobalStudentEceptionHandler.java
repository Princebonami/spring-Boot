package com.springboot.crud1.Exception;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.Persistence;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalStudentEceptionHandler {
	
	@ExceptionHandler(NoSuchElementFoundEXception.class)
	public ResponseEntity<Object> handleNoSuchElementFOundException()
	{
		return new ResponseEntity<Object>("Requested student Id is not available provide correct studentId",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchStudentNameFoundException.class)
	public ResponseEntity<Object> handleNoSuchStudentNameFOundEXception()
	{
		return new ResponseEntity<Object>("No such student available please provide correct student name ",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String, String> respMap=new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach(error->{
			String field= ((FieldError)error).getField();
			
			String message=error.getDefaultMessage();
			
			respMap.put(field, message);
			
		});
		
		return new ResponseEntity<Map<String,String>>(respMap,HttpStatus.BAD_REQUEST);
		
	}
	
//	Persistence.

}
