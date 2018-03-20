package com.nwm.springbootweb.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestResponse<T> {
	public enum Status {
		OK, ERROR, VALIDATION_ERROR
	}
	private Status status;
	private String requestUrl;
	private String timestamp;
	private T response;
	private List<String> errorMessageList;
	
	public RestResponse() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		timestamp = sdf.format(new Date());
		errorMessageList = new ArrayList<String>();
	}
	public RestResponse(Status s, String u) {
		this();
		status = s;
		requestUrl = u;
	}
	public RestResponse(Status s, String u, T r) {
		this();
		status = s;
		requestUrl = u;
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
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	public List<String> getErrorMessageList() {
		return errorMessageList;
	}
	public void setErrorMessageList(List<String> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}
}