package com.tracker.dao;

import com.tracker.Exceptions.ApplicationException;
import com.tracker.model.Expense;
import com.tracker.model.Income;

public interface IIncome {

	public String addIncome(Income income) throws ApplicationException;
}
