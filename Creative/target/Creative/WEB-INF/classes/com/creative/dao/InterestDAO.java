package com.creative.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.creative.util.HibernateUtil;
import com.creative.model.Interest;

public class InterestDAO {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public InterestDAO() {

	}

	public List<Interest> getInterests()

	{

		Session s = sessionFactory.openSession();

		List<Interest> interests = s.createCriteria(Interest.class).list();

		s.close();
		return interests;

	}

	public Interest getInterest(int category)

	{

		Session s = sessionFactory.openSession();

		Criteria cr = s.createCriteria(Interest.class);

		cr.add(Restrictions.eq("category", category));

		Interest interest = (Interest) cr.list().get(0);

		s.close();
		return interest;

	}
}
