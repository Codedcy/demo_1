package com.example.bean;

public class Spot {
	private int graId;
	private int spotId;
	private double lng;
	private double lat;
	private int content;
	private String spotName;
	public int getGraId() {
		return graId;
	}
	public void setGraId(int graId) {
		this.graId = graId;
	}
	public int getSpotId() {
		return spotId;
	}
	public void setSpotId(int spotId) {
		this.spotId = spotId;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public int getContent() {
		return content;
	}
	public void setContent(int content) {
		this.content = content;
	}
	public String getSpotName() {
		return spotName;
	}
	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}
	@Override
	public String toString() {
		return "Spot [graId=" + graId + ", spotId=" + spotId + ", lng=" + lng + ", lat=" + lat + ", content=" + content
				+ ", spotName=" + spotName + "]";
	}
	
	
}
