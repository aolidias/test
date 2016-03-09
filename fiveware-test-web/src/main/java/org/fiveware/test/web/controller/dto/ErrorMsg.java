package org.fiveware.test.web.controller.dto;

/**
 * Dto to error msg
 * @author aolidas
 *
 */
public class ErrorMsg {
	private String errorMessage;
	
	public ErrorMsg(String errorMessage) {
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