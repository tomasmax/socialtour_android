package com.socialtour.models;

import java.util.Date;

public class POIType {
	private int id;
	private String name;
	private boolean isRoute;
	private String imageSmallFileName;
	private String imageMedFileName;
	private String imageBigFileName;
	private int imageFileSize;
	private Date imageUpdatedAt;
	private Date createdAt;
	private Date updatedAt;
	
	public POIType(int id, String name, boolean isRoute, Date createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.isRoute = isRoute;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isRoute() {
		return isRoute;
	}
	
	public void setRoute(boolean isRoute) {
		this.isRoute = isRoute;
	}
	
	public int getImageFileSize() {
		return imageFileSize;
	}
	
	public void setImageFileSize(int imageFileSize) {
		this.imageFileSize = imageFileSize;
	}
	
	public Date getImageUpdatedAt() {
		return imageUpdatedAt;
	}
	
	public void setImageUpdatedAt(Date imageUpdatedAt) {
		this.imageUpdatedAt = imageUpdatedAt;
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

	public String getImageSmallFileName() {
		return imageSmallFileName;
	}

	public void setImageSmallFileName(String imageSmallFileName) {
		this.imageSmallFileName = imageSmallFileName;
	}

	public String getImageMedFileName() {
		return imageMedFileName;
	}

	public void setImageMedFileName(String imageMedFileName) {
		this.imageMedFileName = imageMedFileName;
	}

	public String getImageBigFileName() {
		return imageBigFileName;
	}

	public void setImageBigFileName(String imageBigFileName) {
		this.imageBigFileName = imageBigFileName;
	}	
}
