package com.socialtour.models;

import java.util.Date;

public class RoutePoint {
	private int id;
	private int POIId;
	private Coordenates coordenates;
	private Date createdAt;
	private Date updatedAt;
	
	public RoutePoint(int id, int pOIId, Coordenates coordenates, Date createdAt) {
		super();
		this.id = id;
		POIId = pOIId;
		this.coordenates = coordenates;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPOIId() {
		return POIId;
	}
	
	public void setPOIId(int pOIId) {
		POIId = pOIId;
	}
	
	public Coordenates getCoordenates() {
		return coordenates;
	}
	
	public void setCoordenates(Coordenates coordenates) {
		this.coordenates = coordenates;
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
}
