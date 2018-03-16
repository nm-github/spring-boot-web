package com.nwm.springbootweb.model;

public class Record {
	private long id;
	private String artist;
	private String album;
	private String type;
	private int year;
	
	public Record() {}
	
	public Record(long id, String artist, String album, String type, int year) {
		super();
		this.id = id;
		this.artist = artist;
		this.album = album;
		this.type = type;
		this.year = year;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}