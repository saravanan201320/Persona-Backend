package com.creative.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creative.dao.InterestDAO;
import com.creative.model.Interest;

@Service
public class InterestServiceImpl implements InterestService {
   @Autowired
    private InterestDAO interestDao;
	public List<Interest> getInterests() {
		
		return interestDao.getInterests();
	}

	public Interest getInterest(int category) {
		
		return interestDao.getInterest(category);
	}

	@Override
	public List<Interest> getInterests(String category) {
		// TODO Auto-generated method stub
		return interestDao.getInterestList(category);
	}

}
