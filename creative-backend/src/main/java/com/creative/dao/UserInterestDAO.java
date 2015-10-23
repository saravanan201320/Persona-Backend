package com.creative.dao;

import java.util.List;

import com.creative.model.Interest;
import com.creative.model.UserInterest;

public interface UserInterestDAO {
	public List<UserInterest> getUserInterests(int userID);

	public List<UserInterest> getUserIDs(int interest);
}
