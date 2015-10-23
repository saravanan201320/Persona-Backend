package com.creative.model;

import java.sql.Date;

public class UserInterest {
	private int userInterestId;
	private int interestId;
	private Date createdTS;
	private String createdBy;
	private Date updatedTS;
	private String updatedBy;

	public int getUserInterestId() {
		return userInterestId;
	}

	public void setUserInterestId(int userInterestId) {
		this.userInterestId = userInterestId;
	}

	public int getInterestId() {
		return interestId;
	}

	public void setInterestId(int interestId) {
		this.interestId = interestId;
	}

	public Date getCreatedTS() {
		return createdTS;
	}

	public void setCreatedTS(Date createdTS) {
		this.createdTS = createdTS;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedTS() {
		return updatedTS;
	}

	public void setUpdatedTS(Date updatedTS) {
		this.updatedTS = updatedTS;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}