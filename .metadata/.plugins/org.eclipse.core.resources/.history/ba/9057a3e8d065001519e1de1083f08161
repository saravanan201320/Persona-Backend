package com.creative.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.creative.model.Interest;

@Repository
public class InterestDAOImpl implements InterestDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
 
    

	@SuppressWarnings("unchecked")
	public List<Interest> getInterests()

	{

       List<Interest> interests = sessionFactory.getCurrentSession().createCriteria(Interest.class).list();
		return interests;

	}

	public Interest getInterest(int category)

	{

		

		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Interest.class);

		cr.add(Restrictions.eq("category", category));

		Interest interest = (Interest) cr.list().get(0);

		
		return interest;

	}
}
