package com.project.technicalTest.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(String.format(message));
	}
	
	public ResourceNotFoundException(String message,Throwable throwable) {
		super(message, throwable);
	}
	
}
