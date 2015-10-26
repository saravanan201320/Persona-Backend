package com.creative.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.creative.model.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.openSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsers()
	{
       List<User> users = getSession().createCriteria(User.class).list();
       getSession().close();
       return users;
	}

	@Override
	public void saveUser(User user) {
		getSession().saveOrUpdate(user);
		getSession().close();
		
	}

	@Override
	public User getUser(int userId) {
		
		 List<User> userList=getSession().createQuery("from User where userID=:userId").setParameter("userId", userId).list();
		 return userList.get(0);
	}
}
