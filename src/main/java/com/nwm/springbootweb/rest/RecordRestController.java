package com.nwm.springbootweb.rest;

import com.nwm.springbootweb.model.Record;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
public class RecordRestController {
	private static final Logger logger = LoggerFactory.getLogger(RecordRestController.class);
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping(value="/byid", method=RequestMethod.POST)
	public ResponseEntity<Record> getRecordById(@RequestBody String id) {
		logger.info("********** id: " + id);
		HttpStatus status = HttpStatus.OK;
		long longId = 0;
		Record r = null;
		
		try {
			longId = Long.parseLong(id);
			r = new Record(longId, "Metallica", "Kill Em All", "LP");
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
				
		return new ResponseEntity<Record>(r, status);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public ResponseEntity<List<Record>> getRecordList() {
		List<Record> list = new ArrayList<Record>();
		list.add(new Record(0, "Metallica", "Kill Em All", "LP"));
		list.add(new Record(1, "Metallica", "Ride the Lightning", "LP"));
		list.add(new Record(2, "Metallica", "Master of Puppets", "LP"));
		list.add(new Record(3, "Metallica", "And Justice for All", "LP"));
		list.add(new Record(4, "Metallica", "Black Album", "LP"));
		return new ResponseEntity<List<Record>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public ResponseEntity<Record> insertRecord(@RequestBody Record record) {
		return new ResponseEntity<Record>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ResponseEntity<Record> updateRecord(@RequestBody Record record) {
		return new ResponseEntity<Record>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ResponseEntity<Record> deleteRecord(long id) {
		return new ResponseEntity<Record>(HttpStatus.OK);
	}
}