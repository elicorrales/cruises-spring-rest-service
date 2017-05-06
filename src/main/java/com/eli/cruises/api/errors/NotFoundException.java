package com.eli.cruises.api.errors;

public class NotFoundException extends RuntimeException {

	public NotFoundException() { super(); }
	
	public NotFoundException(String message) { super(message); }
}
