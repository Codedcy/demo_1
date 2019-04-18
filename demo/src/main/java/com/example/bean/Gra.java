package com.example.bean;


public class Gra {
	private int graId;
	private String graName;
	private String graClass;
	private int lv;
	private double lat;
	private double lng;
	private int tickets_sum;
	private int tickets_today;
	private int people;
	
	
	public int getTickets_sum() {
		return tickets_sum;
	}
	public void setTickets_sum(int tickets_sum) {
		this.tickets_sum = tickets_sum;
	}
	public int getTickets_today() {
		return tickets_today;
	}
	public void setTickets_today(int tickets_today) {
		this.tickets_today = tickets_today;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getGraClass() {
		return graClass;
	}
	public void setGraClass(String graClass) {
		this.graClass = graClass;
	}
	public int getGraId() {
		return graId;
	}
	public void setGraId(int graId) {
		this.graId = graId;
	}
	public String getGraName() {
		return graName;
	}
	public void setGraName(String graName) {
		this.graName = graName;
	}
	
	
}
