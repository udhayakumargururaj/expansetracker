package com.tracker.daoImpl;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tracker.DB.MongooConnect;
import com.tracker.Exceptions.ApplicationException;
import com.tracker.dao.IRegister;
import com.tracker.model.Register;

public class RegisterDaoImpl implements IRegister{

	@Override
	public String addNewUser(Register register) throws ApplicationException {
		String result = "";
		try{
		MongoDatabase database = MongooConnect.getInstance().init();
		MongoCollection<Document> collection = database.getCollection("dd");
		Document document = new Document("mobile", register.getMobileNumber())
							.append("username", register.getUserName())
							.append("password", register.getPassword())
							.append("email", register.getEmail());
		collection.insertOne(document);
		result = "Document inserted successfully";
		} catch(Exception e) {
			throw new ApplicationException("There are some issues on inserting the document");
		}
		return result;
	}

}
