package com.nwm.springbootweb.model;

public class Record {
	private long id;
	private String artist;
	private String album;
	private String type;
	
	public Record() {}
	
	public Record(long id, String artist, String album, String type) {
		super();
		this.id = id;
		this.artist = artist;
		this.album = album;
		this.type = type;
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
}