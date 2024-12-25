package com.example.HospitalManagementSystem.Entity;

import org.springframework.stereotype.Component;


public class Hospital {
	private int id;
	private String name;
	private String city;
	public Hospital() {
		super();
	}
	public Hospital(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	

}
