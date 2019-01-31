package com.tracker.daoImpl;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.tracker.DB.MongooConnect;
import com.tracker.dao.IUser;
import com.tracker.model.User;

public class UserDaoImpl implements IUser {

	private DBObject getUserDetails(String username) {
		// get database and
		DB database = MongooConnect.getInstance().init();
		DBCollection collection = database.getCollection("authentication");
		DBObject query = new BasicDBObject("username", username);
		DBCursor cursor = collection.find(query);
		DBObject myDoc = cursor.one();
		return myDoc;
	}
	
	@Override
	public boolean authenticate(User userDetails) {
		String userName = userDetails.getUserName();
		String password = userDetails.getPassword();
		DBObject dbObject = getUserDetails(userName);
		final String dbUser = (String) dbObject.get("username");
		final String dbPassword = (String)  dbObject.get("password");
		if(userName.equalsIgnoreCase(dbUser) && password.equalsIgnoreCase(dbPassword)) {
			return true;
		}
		
		return false;
	}

}
