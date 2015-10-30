package com.creative.service;

import java.util.List;

import com.creative.model.UserDetails;
import com.creative.model.UserPost;

public interface UserPostService {
	public void saveUserPost(UserPost userPost);

	public List<UserPost> getUserPosts();

	public List<UserDetails> getUserDetails();
}
