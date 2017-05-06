package com.eli.cruises.api.errors;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpStatus status;
	private String message;
	private List<String> errors;

	public ApiError(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ApiError(HttpStatus status, String message, List<String> errors) {
		this(status,message);
		this.errors = errors;
	}

	public ApiError(HttpStatus status, String message, String error) {
		this(status,message);
		errors = Arrays.asList(error);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
