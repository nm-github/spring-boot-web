package com.nwm.springbootweb.rest;

import com.nwm.springbootweb.exception.ValidationException;
import com.nwm.springbootweb.model.Record;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
	
	@Autowired
	private HttpServletRequest request;
	
	@ExceptionHandler(Exception.class)
	public RestResponse<Record> handleExceptionCustom(Exception ex, WebRequest webRequest) {
		logger.error("An error occurred while processing your request.", ex);
		
		RestResponse<Record> response = new RestResponse<Record>();
		response.setRequestUrl(request.getRequestURL().toString());
		response.setStatus(RestResponse.Status.ERROR);
		response.getErrorMessageList().add("An error occurred while processing your request.");
		return response;
	}
	
	@ExceptionHandler(ValidationException.class)
	public RestResponse<Record> handleValidationExceptionCustom(ValidationException ex, WebRequest webRequest) {
		RestResponse<Record> response = new RestResponse<Record>();
		response.setRequestUrl(request.getRequestURL().toString());
		response.setStatus(RestResponse.Status.VALIDATION_ERROR);
		response.getErrorMessageList().addAll(ex.getErrorMessageList());
		return response;
	}
}
