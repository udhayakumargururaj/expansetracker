package com.tracker.dao;

import com.tracker.model.User;

public interface IUser {

	public boolean authenticate(User userDetail);
	
	
}
