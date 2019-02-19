package com.tracker.dao;

import java.util.ArrayList;

import com.tracker.Exceptions.ApplicationException;
import com.tracker.model.Expense;

public interface IExpense {

	public String addExpense(Expense expenses) throws ApplicationException;
	public ArrayList<Expense> getExpense() throws ApplicationException;
}
