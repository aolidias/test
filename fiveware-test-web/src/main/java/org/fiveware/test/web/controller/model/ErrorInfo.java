package org.fiveware.test.web.controller.model;

public class ErrorInfo {
	private String errorMessage;
	
	public ErrorInfo(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}