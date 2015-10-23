package com.creative.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserPost {
	@Id
	@GeneratedValue
	@Column
	private int userPostId;
	@Column
	private int userId;
	@Column
	private String Category;
	@Column
	private String Sub_Category;
	@Column
	private String description;
	@Column
	private String image;
	
	@Embedded
	private UpdateDetails updateDetails;

	public int getUserPostId() {
		return userPostId;
	}

	public void setUserPostId(int userPostId) {
		this.userPostId = userPostId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	

	
	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getSub_Category() {
		return Sub_Category;
	}

	public void setSub_Category(String sub_Category) {
		Sub_Category = sub_Category;
	}

	public UpdateDetails getUpdateDetails() {
		return updateDetails;
	}

	public void setUpdateDetails(UpdateDetails updateDetails) {
		this.updateDetails = updateDetails;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}



}
