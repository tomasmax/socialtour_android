package com.socialtour.models;

import java.util.Date;

public class Event {
	private int id;
	private String description;
	private String summary;
	private Date createdAt;
	private Date updatedAt;
	private Date startsAt;
	private Date endsAt;
	
	private int poiId;

	public Event(int id, String description, String summary, Date createdAt, Date startsAt,	Date endsAt, int poiId) {
		super();
		this.id = id;
		this.description = description;
		this.summary = summary;
		this.createdAt = createdAt;
		this.startsAt = startsAt;
		this.endsAt = endsAt;
		this.poiId = poiId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public Date getStartsAt() {
		return startsAt;
	}

	public void setStartsAt(Date startsAt) {
		this.startsAt = startsAt;
	}

	public Date getEndsAt() {
		return endsAt;
	}

	public void setEndsAt(Date endsAt) {
		this.endsAt = endsAt;
	}

	public int getPoiId() {
		return poiId;
	}

	public void setPoiId(int poiId) {
		this.poiId = poiId;
	}
}
