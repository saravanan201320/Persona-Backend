package com.creative.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class UserImage implements Serializable{
	@Id
	@GeneratedValue
	@Column
	private int imageID;
	@Column(columnDefinition = "LONGBLOB")
	private byte[] profileImage;
	
	@Column
	private Integer userID;
	public Integer getImageID() {
		return imageID;
	}
	public void setImageID(Integer imageID) {
		this.imageID = imageID;
	}
	
	public byte[] getProfileImage() {
		return profileImage;
	}
	
	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	
}