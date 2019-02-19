package com.tracker.daoImpl;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.FindIterable;
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

	@Override
	public ArrayList<Expense> getExpense() throws ApplicationException {
		ArrayList<Expense> listExpenses = new ArrayList<>();
		try {
			MongoDatabase database = MongooConnect.getInstance().init();
			MongoCollection<Document> collection = database.getCollection(AppConstants.COL_EXPENSE);
			FindIterable<Document> list = collection.find();
			Expense expense = null;
			for(Document d : list) {
				expense = new Expense();
				expense.setAmount(d.getInteger("amount"));
				expense.setCategory(d.getString("category"));
				expense.setNotes(d.getString("notes"));
				listExpenses.add(expense);
			}
			
		} catch(Exception e) {
			throw new ApplicationException("error reading expense collection");
		}
		return listExpenses;
	}
	
	
	
}
