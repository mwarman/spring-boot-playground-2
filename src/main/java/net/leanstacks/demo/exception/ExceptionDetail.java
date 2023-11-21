package net.leanstacks.demo.exception;

import org.springframework.http.HttpStatus;

public class ExceptionDetail {
	
	private HttpStatus httpStatus;
	
	private String message;
	
	public ExceptionDetail(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}
	
	public int getStatus() {
		return this.httpStatus.value();
	}
	
	public String getStatusText() {
		return this.httpStatus.getReasonPhrase();
	}
	
	public String getMessage() {
		return this.message;
	}

}
