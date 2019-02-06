package com.tracker.daoImpl;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tracker.DB.MongooConnect;
import com.tracker.dao.IUser;
import com.tracker.model.User;

public class UserDaoImpl implements IUser {

	private Document getUserDetails(String username) {
		// get database and
		MongoDatabase database = MongooConnect.getInstance().init();
		MongoCollection<Document> collection = database.getCollection("authentication");
		FindIterable<Document> cursor = collection.find(new Document("username", username));
		Document myDoc = cursor.first();
		return myDoc;
	}
	
	@Override
	public boolean authenticate(User userDetails) {
		String userName = userDetails.getUserName();
		String password = userDetails.getPassword();
		Document dbObject = getUserDetails(userName);
		final String dbUser = (String) dbObject.get("username");
		final String dbPassword = (String)  dbObject.get("password");
		if(userName.equalsIgnoreCase(dbUser) && password.equalsIgnoreCase(dbPassword)) {
			return true;
		}
		
		return false;
	}

}
