package com.tracker.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="There is an issue in completing request")
public class ApplicationException extends Exception {
	
	public ApplicationException(String errorMsg, Throwable err) {
		super(errorMsg, err);
	}
	
	
	public ApplicationException(String errorMsg) {
		super(errorMsg);
	}
	

}
