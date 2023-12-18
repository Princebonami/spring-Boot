package com.springboot.EmployeeManagement.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException{
	
	
//	@ExceptionHandler
//	@Override
//	protected ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//		Map<String, String> respMap=new HashMap<String, String>();
//		ex.getBindingResult().getAllErrors().forEach(error->{
//			String field= ((FieldError)error).getField();
//			
//			String message=error.getDefaultMessage();
//			
//			respMap.put(field, message);
//			
//		});
//		
//		return new ResponseEntity<Map<String,String>>(respMap,HttpStatus.BAD_REQUEST);
//	}

	@ExceptionHandler(NoSuchElementFoundException.class)
	public ResponseEntity<Object> handlerNoSuchElementFoundException()
	{
		return new ResponseEntity<>("No Data Is Available Regarding Particular Id",HttpStatus.NO_CONTENT);
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
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> handleHttpMessagNotReadableException(HttpMessageNotReadableException ex)
	{	
		String message="Invalid data in age or salary :" +ex.getMessage();
		return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		
	}
	

}
