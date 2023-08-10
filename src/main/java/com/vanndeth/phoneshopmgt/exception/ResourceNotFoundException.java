package com.vanndeth.phoneshopmgt.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException{
	/*
	public ResourceNotFoundException(HttpStatus httpStatus, String message) {
		super(httpStatus, message);
		// TODO Auto-generated constructor stub
	}
	*/
	
	public ResourceNotFoundException(String resource, Long id) {
		super(HttpStatus.NOT_FOUND, String.format("%s with id = %ld not found", resource, id));
		// TODO Auto-generated constructor stub
	}

}
