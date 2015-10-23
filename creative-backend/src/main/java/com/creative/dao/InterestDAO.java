package com.creative.dao;

import java.util.List;

import com.creative.model.Interest;

public interface InterestDAO {
	public List<Interest> getInterests();
	public Interest getInterest(int category);
	public List<Interest> getInterestList(String category);

}
