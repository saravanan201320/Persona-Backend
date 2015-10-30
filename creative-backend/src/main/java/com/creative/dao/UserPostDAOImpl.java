package com.creative.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.creative.model.User;
import com.creative.model.UserDetails;
import com.creative.model.UserPost;

@Repository
public class UserPostDAOImpl implements UserPostDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public void savePostUser(UserPost userPost) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(userPost);
		getSession().close();
		
	}

	@Override
	public List<UserPost> getUserPosts() {
		List<UserPost> userPosts = getSession().createCriteria(UserPost.class).list();
	       getSession().close();
	       return userPosts;
	}

	@Override
	public List<UserDetails> getUserDetails() {
		List<UserDetails> userDetails = getSession().createCriteria(UserDetails.class).list();
		// TODO Auto-generated method stub
		return userDetails;
	}
	

}
