package com.nwm.springbootweb.rest;

import com.nwm.springbootweb.exception.ValidationException;
import com.nwm.springbootweb.model.Record;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private HttpServletRequest request;
	
	@ExceptionHandler(Exception.class)
	public RestResponse<Record> handleExceptionCustom(Exception ex, WebRequest webRequest) {
		RestResponse<Record> response = new RestResponse<Record>();
		
		response.setRequestUrl(request.getRequestURL().toString());
		response.setTimestamp(new Date());
		response.setStatus(RestResponse.Status.ERROR);
		response.setException(ex);
		
		Map<String, String> defaultMessage = new HashMap<String, String>();
		defaultMessage.put("*", "An error occurred while processing your request.");
		
		response.setErrorMessageList(Arrays.asList(defaultMessage));
		
		return response;
	}
	
	@ExceptionHandler(ValidationException.class)
	public RestResponse<Record> handleValidationExceptionCustom(ValidationException ex, WebRequest webRequest) {
		RestResponse<Record> response = new RestResponse<Record>();

		response.setRequestUrl(request.getRequestURL().toString());
		response.setTimestamp(new Date());
		response.setStatus(RestResponse.Status.VALIDATION_ERROR);
		response.setErrorMessageList(ex.getErrorMessageList());
		
		return response;
	}
}
