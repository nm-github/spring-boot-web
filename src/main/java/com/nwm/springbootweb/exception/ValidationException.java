package com.nwm.springbootweb.exception;

import java.util.List;
import java.util.Map;

public class ValidationException extends Exception {
	private static final long serialVersionUID = 1L;
	private List<Map<String, String>> errorMessageList;
	
	public List<Map<String, String>> getErrorMessageList() {
		return errorMessageList;
	}
	public void setErrorMessageList(List<Map<String, String>> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}
}