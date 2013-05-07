package com.socialtour.models;

public class Ratings {
	private int id;
	private int POIId;
	private float rating;
	
	public Ratings(int id, float rating) {
		super();
		this.id = id;
		this.rating = rating;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public float getRating() {
		return rating;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getPOIId() {
		return POIId;
	}

	public void setPOIId(int pOIId) {
		POIId = pOIId;
	}	
}
