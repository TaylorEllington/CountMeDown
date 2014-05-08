package com.countmedown;

import java.util.Date;

public class Event {
	private String name;
	private String startDate;
	private String endDate;
	private String description;
	
	public Event(){
		this.name = "Placeholder Name";
		this.description = "Placeholder Description";
	}
	
	

	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
