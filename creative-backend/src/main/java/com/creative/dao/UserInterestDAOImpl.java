package com.creative.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.creative.model.Interest;
import com.creative.model.User;
import com.creative.model.UserInterest;

@Repository
public class UserInterestDAOImpl implements UserInterestDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.openSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInterest> getUserInterests(int userID) {
//		List<UserInterest> userInterests = getSession().createCriteria(UserInterest.class).list();
//	    getSession().close();
//	    return userInterests;
	    Criteria cr = getSession().createCriteria(User.class);

		cr.add(Restrictions.eq("userID", userID));
		User user=(User) cr.list().get(0);
		
		//List<UserInterest> userInterest = (List<UserInterest>) cr.list().get(0);
		getSession().close();

		return user.getUserInterest();
	}

	@Override
	public List<UserInterest> getUserIDs(int interest) {
		// TODO Auto-generated method stub
		List<UserInterest> user=getSession().createQuery("from UserInterest where interestId=:interestId").setParameter("interestId", interest).list();
//		Criteria cr = getSession().createCriteria(User.class);
//
//		cr.add(Restrictions.eq("interestId", interest));
//		User user=(User) cr.list().get(0);
//		
//		//List<UserInterest> userInterest = (List<UserInterest>) cr.list().get(0);
		getSession().close();

		return user;
	}
}