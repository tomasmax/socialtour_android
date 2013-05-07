package com.socialtour.models;

import java.util.Date;

public class Comment {
	private int id;
	private String comment;
	private Date createdAt;
	private Date updatedAt;
	
	private int userId;
	private int poiId;
	
	public Comment(int id, String comment, Date createdAt, int userId, int poiId) {
		super();
		this.id = id;
		this.comment = comment;
		this.createdAt = createdAt;
		this.userId = userId;
		this.poiId = poiId;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getPoiId() {
		return poiId;
	}
	
	public void setPoiId(int poiId) {
		this.poiId = poiId;
	}
}
