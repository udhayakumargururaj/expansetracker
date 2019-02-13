package com.tracker.daoImpl;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tracker.DB.MongooConnect;
import com.tracker.Exceptions.ApplicationException;
import com.tracker.constants.AppConstants;
import com.tracker.dao.IExpense;
import com.tracker.model.Expense;

public class ExpenseDaoImpl implements IExpense {

	@Override
	public String addExpense(Expense expenses) throws ApplicationException {
		String result = "";
		try{
			MongoDatabase database = MongooConnect.getInstance().init();
			MongoCollection<Document> collection = database.getCollection(AppConstants.COL_EXPENSE);
			Document document = new Document(AppConstants.EXP_FIELD_CATEGORY, expenses.getCategory())
					.append(AppConstants.EXP_FIELD_NOTES, expenses.getNotes())
					.append(AppConstants.EXP_FIELD_AMOUNT, expenses.getAmount());
			collection.insertOne(document);
			result = AppConstants.EXP_SUCCESS_MESSAGE;
		} catch(Exception e) {
			throw new ApplicationException(AppConstants.APP_ERROR_MESSAGE);
		}
		return result;
	}
	
}
