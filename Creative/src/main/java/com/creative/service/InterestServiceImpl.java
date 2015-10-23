package com.creative.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creative.dao.InterestDAO;
import com.creative.model.Interest;

@Service
@Transactional
public class InterestServiceImpl implements InterestService {
@Autowired
private InterestDAO interestDao;
	public List<Interest> getInterests() {
		
		return interestDao.getInterests();
	}

	public Interest getInterest(int category) {
		
		return interestDao.getInterest(category);
	}

}
