package com.tracker.BO;

import com.tracker.dao.IUser;
import com.tracker.daoImpl.UserDaoImpl;
import com.tracker.model.User;

public class UserBO {
	 private static IUser userDao = null;
	
	public UserBO() {
		userDao = new UserDaoImpl(); 
	}
	
	public boolean authenticate(User user) {
		return userDao.authenticate(user);
	}
}
