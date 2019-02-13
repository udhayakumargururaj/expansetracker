package com.tracker.daoImpl;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tracker.DB.MongooConnect;
import com.tracker.Exceptions.ApplicationException;
import com.tracker.constants.AppConstants;
import com.tracker.dao.IRegister;
import com.tracker.model.Register;

public class RegisterDaoImpl implements IRegister{

	@Override
	public String addNewUser(Register register) throws ApplicationException {
		String result = "";
		try{
			MongoDatabase database = MongooConnect.getInstance().init();
			MongoCollection<Document> collection = database.getCollection(AppConstants.COL_REGISTER);
			Document document = new Document(AppConstants.REG_FIELD_MOBILE, register.getMobileNumber())
					.append(AppConstants.REG_FIELD_USERNAME, register.getUserName())
					.append(AppConstants.REG_FIELD_PASSWORD, register.getPassword())
					.append(AppConstants.REG_FIELD_EMAIL, register.getEmail());
			collection.insertOne(document);
			result = AppConstants.REG_SUCCESS_MESSAGE;
		} catch(Exception e) {
			throw new ApplicationException(AppConstants.APP_ERROR_MESSAGE);
		}
		return result;
	}

}
