package com.project.technicalTest.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotEligibleExceptionHandler {
	
	@ExceptionHandler(value = {NotEligibleException.class})
	public ResponseEntity<Object> handleNotEligibleException(NotEligibleException e){
		ApiException apiException = new ApiException(
				e.getMessage(),
				HttpStatus.NOT_ACCEPTABLE,
				ZonedDateTime.now(ZoneId.of("Z")));
		
		return new ResponseEntity<>(apiException, HttpStatus.NOT_ACCEPTABLE);
		
		
	}
}
