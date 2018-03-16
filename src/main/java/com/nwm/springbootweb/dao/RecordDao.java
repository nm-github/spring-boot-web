package com.nwm.springbootweb.dao;

import com.nwm.springbootweb.model.Record;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class RecordDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Record get(long id) {
		Record record = jdbcTemplate.queryForObject("select * from record where id = ?",
				new Object[] {id},
				new BeanPropertyRowMapper<Record>(Record.class));
		return record;
	}
	
	public List<Record> getAll() {
		List<Record> list = jdbcTemplate.query("select * from record",
				new BeanPropertyRowMapper<Record>(Record.class));
		return list;
	}
	
	public int insert(Record record) {
		return jdbcTemplate.update("insert into record (artist, album, type, year) values (?, ?, ?, ?)",
				record.getArtist(),
				record.getAlbum(),
				record.getType(),
				record.getYear());
	}
	
	public int update(Record record) {
		return jdbcTemplate.update("update record set artist = ?, album = ?, type = ?, year = ? where id = ?",
				record.getArtist(),
				record.getAlbum(),
				record.getType(),
				record.getYear(),
				record.getId());
	}
	
	public int delete(long id) {
		return jdbcTemplate.update("delete from record where id = ?", id);
	}
}