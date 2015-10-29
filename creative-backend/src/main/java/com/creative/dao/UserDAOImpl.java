package com.creative.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.creative.model.User;
import com.creative.model.UserImage;

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

	@Override
	public void saveImage(UserImage userImage) {
		// TODO Auto-generated method stub
		System.out.println("DAO"+ + userImage.getUserID()+" "+userImage.getProfileImage());
		List<UserImage> selectQuery = getSession().createQuery("from UserImage where userID=:userId").setParameter("userId", userImage.getUserID()).list();
		System.out.println("selectQuery--->"+selectQuery.size());
		if(selectQuery.size() <= 0){
			getSession().save(userImage);
		}
		else{
			
			getSession().createQuery("update UserImage set profileImage=:profileImage where userID=:userID").setParameter("profileImage", userImage.getProfileImage()).setParameter("userID", userImage.getUserID()).executeUpdate();
		}
		
		getSession().close();
	}

	@Override
	public List<UserImage> getProfileImage(int userId) {
		// TODO Auto-generated method stub
		List<UserImage> userProfileImage = getSession().createQuery("from UserImage where userID=:userId").setParameter("userId", userId).list();
				
	       getSession().close();
	       
		return userProfileImage;
	}

	
}