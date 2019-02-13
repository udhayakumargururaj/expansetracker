package com.tracker.dao;

import com.tracker.Exceptions.ApplicationException;
import com.tracker.model.Expense;

public interface IExpense {

	public String addExpense(Expense expenses) throws ApplicationException;
}
