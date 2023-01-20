package com.project.technicalTest.exceptions;

public class RequiredFieldsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public RequiredFieldsException(String message) {
		super(message);
	}

	public RequiredFieldsException(String message,Throwable throwable) {
		super(message, throwable);
	}
}
