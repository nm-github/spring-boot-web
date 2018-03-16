package com.nwm.springbootweb.rest;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class RestResponse<T> {
	public enum Status {
		OK, ERROR, VALIDATION_ERROR
	}
	private Status status;
	private String requestUrl;
	private Date timestamp;
	private T response;
	private Exception exception;
	private List<Map<String, String>> errorMessageList;
	
	public RestResponse() {	
	}
	public RestResponse(Status s, String u, Date d) {
		status = s;
		requestUrl = u;
		timestamp = d;
	}
	public RestResponse(Status s, String u, Date d, T r) {
		status = s;
		requestUrl = u;
		timestamp = d;
		response = r;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	public List<Map<String, String>> getErrorMessageList() {
		return errorMessageList;
	}
	public void setErrorMessageList(List<Map<String, String>> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}
}