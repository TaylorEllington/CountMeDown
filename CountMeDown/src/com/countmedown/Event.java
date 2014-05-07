package com.countmedown;

import java.util.Date;

public class Event {
	private String name;
	private Date startDate;
	private Date endDate;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
