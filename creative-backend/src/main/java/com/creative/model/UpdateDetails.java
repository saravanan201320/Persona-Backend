package com.creative.model;

import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class UpdateDetails {
	
	private String createdTS;
    private String createdBy;
	private String updatedTS;
	private String updatedBy;
	public String getCreatedTS() {
		return createdTS;
	}
	public void setCreatedTS(String createdTS) {
		this.createdTS = createdTS;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedTS() {
		return updatedTS;
	}
	public void setUpdatedTS(String updatedTS) {
		this.updatedTS = updatedTS;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	
	
	
}
