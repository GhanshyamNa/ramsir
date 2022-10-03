package com.infy.springbootrestapicrudapp.app.exception;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobleRestExceptionHandler {
	
	
	  @ExceptionHandler(ProductNotFoundException.class)
	  public  ResponseEntity<ResponseError>	  productNotFoundExceptionHandler(ProductNotFoundException e,HttpServletRequest request){
	  System.out.println("handle"); 
	  ResponseError error=new ResponseError(LocalDate.now(),HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND,e.getMessage(), request.getRequestURI());
	  
	  
	  return new ResponseEntity<ResponseError>(error,HttpStatus.NOT_FOUND); }
	 
}
