package com.socialtour.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class POI implements Serializable {
	private int id;
	private String title;
	private String description;
	private int type;
	private Coordenates coordenates;
	private float rating;
	private int ratingsCount;
	private Date createdAt;
	private Date updatedAt;
	private ArrayList<Coordenates> routePoints;
	
	private int userId;

	public POI(int id, String title, String description, int type, Coordenates coordenates, float rating, int ratingsCount,	Date createdAt, int userId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.type = type;
		this.coordenates = coordenates;
		this.rating = rating;
		this.ratingsCount = ratingsCount;
		this.createdAt = createdAt;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Coordenates getCoordenates() {
		return coordenates;
	}

	public void setCoordenates(Coordenates coordenates) {
		this.coordenates = coordenates;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getRatingsCount() {
		return ratingsCount;
	}

	public void setRatingsCount(int ratingsCount) {
		this.ratingsCount = ratingsCount;
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

	public ArrayList<Coordenates> getRoutePoints() {
		return routePoints;
	}

	public void setRoutePoints(ArrayList<Coordenates> routePoints) {
		this.routePoints = routePoints;
	}
}
