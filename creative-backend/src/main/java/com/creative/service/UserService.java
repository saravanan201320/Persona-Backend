package com.creative.service;

import java.util.List;

import com.creative.model.Interest;
import com.creative.model.User;
import com.creative.model.UserImage;
import com.creative.model.UserInterest;

public interface UserService {
	public void saveUser(User user);
	public int getUsers(String emailId,String password);
	public String getUserPwd(String emailId);
	public String getUserDetails(int userID);
	public List<UserInterest> getUserInterests(int userID);
	public List<UserInterest> getUserID(int interest);
	public User getUser(int userId);
	public void saveImage(UserImage userImage);
	public List<UserImage> getProfileImage();
}
