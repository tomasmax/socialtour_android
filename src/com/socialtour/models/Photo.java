package com.socialtour.models;

import java.util.Date;

import android.graphics.drawable.Drawable;

public class Photo {
	private int id;
	private int POIId;
	private int userId;
	private String imageFileName;
	private String imageContentType;
	private int imageFileSize;
	private Date imageUpdatedAt;
	private Date createdAt;
	private Date updatedAt;
	private Drawable drawable;
	
	public Photo(int id, int pOIId, int userId, Date createdAt) {
		super();
		this.id = id;
		POIId = pOIId;
		this.userId = userId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
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

	public Drawable getDrawable() {
		return drawable;
	}

	public void setDrawable(Drawable drawable) {
		this.drawable = drawable;
	}	
}
