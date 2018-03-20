package com.nwm.springbootweb.processor;

import com.nwm.springbootweb.dao.RecordDao;
import com.nwm.springbootweb.exception.ValidationException;
import com.nwm.springbootweb.model.Record;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecordProcessor {
	@Autowired
	private RecordDao dao;
	
	public Record get(String id) throws Exception {
		long longId;
		
		try {
			longId = Long.parseLong(id);
		} catch (Exception e) {
			List<String> list = new ArrayList<String>();
			list.add("ID is invalid");
			ValidationException ve = new ValidationException(list);
			throw ve;
		}
		
		Record r = dao.get(longId);
		return r;
	}
	
	public List<Record> getList(String sortOption) throws Exception {
		if (sortOption == null)
			sortOption = "1";
		
		List<Record> list = dao.getAll(sortOption);
		return list;
	}
	
	public void insert(Record record) throws Exception {
		List<String> errorList = validate(true);
		if (errorList != null && !errorList.isEmpty())
			throw new ValidationException(errorList);
			
		int count = dao.insert(record);
		if (count != 1)
			throw new Exception();
	}
	
	public void update(Record record) throws Exception {
		List<String> errorList = validate(false);
		if (errorList != null && !errorList.isEmpty())
			throw new ValidationException(errorList);
		
		int count = dao.update(record);
		if (count != 1)
			throw new Exception();
	}
	
	public void delete(String id) throws Exception {
		long longId;
		
		try {
			longId = Long.parseLong(id);
		} catch (Exception e) {
			List<String> list = new ArrayList<String>();
			list.add("ID is invalid");
			ValidationException ve = new ValidationException(list);
			throw ve;
		}
		
		int count = dao.delete(longId);
		if (count != 1)
			throw new Exception();
	}
	
	private List<String> validate(boolean insert) {
		List<String> list = new ArrayList<String>();
		
		if (!insert) {
			// Validate ID
		}
		
		return list;
	}
}