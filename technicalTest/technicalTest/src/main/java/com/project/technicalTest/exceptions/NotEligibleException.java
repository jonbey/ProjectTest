package com.project.technicalTest.exceptions;


public class NotEligibleException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NotEligibleException(String message) {
		super(message);
	}
	
	public NotEligibleException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
