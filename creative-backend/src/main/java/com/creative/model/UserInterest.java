package com.creative.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class UserInterest {
	@Id
	@GeneratedValue
	@Column
	private int userInterestId;
	@Column
	private int interestId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userID")
	private User user;

	@Embedded
	private UpdateDetails updateDetails;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UpdateDetails getUpdateDetails() {
		return updateDetails;
	}

	public void setUpdateDetails(UpdateDetails updateDetails) {
		this.updateDetails = updateDetails;
	}

}
