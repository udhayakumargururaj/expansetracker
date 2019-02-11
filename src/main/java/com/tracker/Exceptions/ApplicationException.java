package com.tracker.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ApplicationException extends RuntimeException {
	private String message;
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}


	public ApplicationException(String errorMsg, Throwable err) {
		super(errorMsg, err);
		this.setMessage(errorMsg);
	}
	
	
	public ApplicationException(String errorMsg) {
		super(errorMsg);
		this.setMessage(errorMsg);
	}
	

}
