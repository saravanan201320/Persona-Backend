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
public class InterestDAOImpl implements InterestDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.openSession();
	}

	@SuppressWarnings("unchecked")
	public List<Interest> getInterests()

	{

		List<Interest> interests = getSession().createCriteria(Interest.class).list();
		getSession().close();
		return interests;

	}

	public Interest getInterest(int category)

	{

		Criteria cr = getSession().createCriteria(Interest.class);

		cr.add(Restrictions.eq("category", category));

		Interest interest = (Interest) cr.list().get(0);
		getSession().close();

		return interest;

	}

	@Override
	public List<Interest> getInterestList(String category) {
		List<Interest> interest=getSession().createQuery("from Interest where category=:category").setParameter("category", category).list();
		return interest;
	}

	
	
}
