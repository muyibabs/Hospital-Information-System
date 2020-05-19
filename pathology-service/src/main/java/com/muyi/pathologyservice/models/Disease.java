package com.muyi.pathologyservice.models;

public class Disease {

	private String id;
	private String name;
	private String symptoms;
	private String treatment;
	
	public Disease() {
	}

	public Disease(String id, String name, String symptoms, String treatment) {
		this.id = id;
		this.name = name;
		this.symptoms = symptoms;
		this.treatment = treatment;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	
	
}
