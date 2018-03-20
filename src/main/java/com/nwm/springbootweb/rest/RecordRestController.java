package com.nwm.springbootweb.rest;

import com.nwm.springbootweb.model.Record;
import com.nwm.springbootweb.processor.RecordProcessor;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
public class RecordRestController {
	private static final Logger logger = LoggerFactory.getLogger(RecordRestController.class);
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private RecordProcessor processor;
	
	@GetMapping("/test")
	public String test() {
		return "Test successful";
	}
	
	@GetMapping("/gettest/{param}")
	public String getTest(@PathVariable("param") String param) {
		return "Get test successful, input param: " + param;
	}
	
	@PostMapping("/byid")
	public RestResponse<Record> getRecordById(@RequestBody String id) throws Exception {
		logger.info("********** /byid, id: " + id);
		
		Record r = processor.get(id);
		
		RestResponse<Record> response = new RestResponse<Record>(
				RestResponse.Status.OK,
				request.getRequestURL().toString(),
				r);
		
		return response;
	}
	
	@PostMapping("/list")
	public RestResponse<List<Record>> getRecordList(@RequestBody String sortOption) throws Exception {
		logger.info("********** /list");
		
		List<Record> list = processor.getList(sortOption);
		
		RestResponse<List<Record>> response = new RestResponse<List<Record>>(
				RestResponse.Status.OK,
				request.getRequestURL().toString(),
				list);
		
		return response;
	}
	
	@PostMapping("/insert")
	public RestResponse<Record> insertRecord(@RequestBody Record record) throws Exception {
		logger.info("********** /insert, record: " + record);
		
		processor.insert(record);
		
		RestResponse<Record> response = new RestResponse<Record>(
				RestResponse.Status.OK,
				request.getRequestURL().toString());
		
		return response;
	}
	
	@PostMapping("/update")
	public RestResponse<Record> updateRecord(@RequestBody Record record) throws Exception {
		logger.info("********** /update, record: " + record);
		
		processor.update(record);
		
		RestResponse<Record> response = new RestResponse<Record>(
				RestResponse.Status.OK,
				request.getRequestURL().toString());
		
		return response;
	}
	
	@PostMapping("/delete")
	public RestResponse<Record> deleteRecord(@RequestBody String id) throws Exception {
		logger.info("********** /delete, id: " + id);
		
		processor.delete(id);
		
		RestResponse<Record> response = new RestResponse<Record>(
				RestResponse.Status.OK,
				request.getRequestURL().toString());
		
		return response;
	}
}