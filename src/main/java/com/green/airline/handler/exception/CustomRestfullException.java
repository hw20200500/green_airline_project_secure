package com.green.airline.handler.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomRestfullException extends RuntimeException {

	private HttpStatus status;
	
	public CustomRestfullException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
	public HttpStatus getStatus() {
        return status;
    }
}