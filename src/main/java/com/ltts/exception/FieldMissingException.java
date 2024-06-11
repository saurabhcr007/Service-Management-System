package com.ltts.exception;

public class FieldMissingException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public FieldMissingException(String message) {
		super(message);
	}

}
