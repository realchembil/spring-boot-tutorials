package com.ashcorp.ssc.photosclone.com.ashcorp.ssc.photosclone.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table("PHOTOS")
public class Photo {
	@Id
	private String id;
	
	 @NotEmpty
	private String fileName;
	
	@JsonIgnore
	private byte[] data;
	
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	private String contentType;
	
	
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Photo(String id, String fileName) {
		super();
		this.id = id;
		this.fileName = fileName;
	}
	
	public Photo() {
		
	}
	
}
