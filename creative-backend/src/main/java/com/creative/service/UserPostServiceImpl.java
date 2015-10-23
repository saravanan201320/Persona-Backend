package com.creative.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creative.dao.UserPostDAO;
import com.creative.model.UserInterest;
import com.creative.model.UserPost;
@Service
public class UserPostServiceImpl implements UserPostService {
	@Autowired
	private UserPostDAO userPostDAO;

	@Override
	public void saveUserPost(UserPost userPost) {
		// TODO Auto-generated method stub
		userPostDAO.savePostUser(userPost);
	}

	@Override
	public List<UserPost> getUserPosts() {
		// TODO Auto-generated method stub
		List<UserPost> userPosts = userPostDAO.getUserPosts();
		return userPosts;
		
	}

}
