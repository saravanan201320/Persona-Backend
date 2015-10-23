package com.creative.dao;

import java.util.List;

import com.creative.model.User;
import com.creative.model.UserPost;

public interface UserPostDAO {
	public void savePostUser(UserPost userPost);

	public List<UserPost> getUserPosts();
}
