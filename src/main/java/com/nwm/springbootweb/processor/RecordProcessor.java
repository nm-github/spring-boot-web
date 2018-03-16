package com.nwm.springbootweb.processor;

import com.nwm.springbootweb.dao.RecordDao;
import com.nwm.springbootweb.exception.ValidationException;
import com.nwm.springbootweb.model.Record;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
			Map<String, String> m = new HashMap<String, String>();
			m.put("id", "invalid");
			ValidationException ve = new ValidationException();
			ve.setErrorMessageList(Arrays.asList(m));
			throw ve;
		}
		
		Record r = dao.get(longId);
		return r;
	}
	
	public List<Record> getList() throws Exception {
		List<Record> list = dao.getAll();
		return list;
	}
	
	public void insert(Record record) throws Exception {
		// TODO: validate input
		
		int count = dao.insert(record);
		if (count != 1)
			throw new Exception();
	}
	
	public void update(Record record) throws Exception {
		// TODO: validate input
		
		int count = dao.update(record);
		if (count != 1)
			throw new Exception();
	}
	
	public void delete(String id) throws Exception {
		long longId;
		
		try {
			longId = Long.parseLong(id);
		} catch (Exception e) {
			Map<String, String> m = new HashMap<String, String>();
			m.put("id", "invalid");
			ValidationException ve = new ValidationException();
			ve.setErrorMessageList(Arrays.asList(m));
			throw ve;
		}
		
		int count = dao.delete(longId);
		if (count != 1)
			throw new Exception();
	}
}