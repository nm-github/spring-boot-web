package com.nwm.springbootweb.exception;

import java.util.List;

public class ValidationException extends Exception {
	private static final long serialVersionUID = 1L;
	private List<String> errorMessageList;
	
	public ValidationException() {
	}
	public ValidationException(List<String> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}
	
	public List<String> getErrorMessageList() {
		return errorMessageList;
	}
	public void setErrorMessageList(List<String> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}
}