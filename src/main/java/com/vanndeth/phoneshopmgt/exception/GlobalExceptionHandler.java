package com.vanndeth.phoneshopmgt.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = ApiException.class)
	public ResponseEntity<?> handleApiException(ApiException e) {
		ErrorResponse errorResponse = new ErrorResponse(e.getHttpStatus(), e.getMessage());
		return ResponseEntity.status(
				e.getHttpStatus())
				.body(errorResponse);
	}

}
