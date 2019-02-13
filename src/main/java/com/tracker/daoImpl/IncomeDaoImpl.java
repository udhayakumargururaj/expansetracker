package com.tracker.daoImpl;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tracker.DB.MongooConnect;
import com.tracker.Exceptions.ApplicationException;
import com.tracker.constants.AppConstants;
import com.tracker.dao.IIncome;
import com.tracker.model.Income;

public class IncomeDaoImpl implements IIncome {

	@Override
	public String addIncome(Income income) throws ApplicationException {
		String result = "";
		try{
			MongoDatabase database = MongooConnect.getInstance().init();
			MongoCollection<Document> collection = database.getCollection(AppConstants.COL_INCOME);
			Document document = new Document(AppConstants.INC_FIELD_SALARY, income.getSalary())
					.append(AppConstants.INC_FIELD_MONTH, income.getMonth());
			collection.insertOne(document);
			result = AppConstants.INC_SUCCESS_MESSAGE;
		} catch(Exception e) {
			throw new ApplicationException(AppConstants.APP_ERROR_MESSAGE);
		}
		return result;
	}

}
