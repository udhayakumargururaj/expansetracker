package com.tracker.BO;

import com.tracker.Exceptions.ApplicationException;
import com.tracker.dao.IExpense;
import com.tracker.daoImpl.ExpenseDaoImpl;
import com.tracker.model.Expense;

public class ExpenseBO {
	private static IExpense expenseDao = null;
	public ExpenseBO() {
		expenseDao = new ExpenseDaoImpl(); 
	}
	public String addExpense(Expense expense) throws ApplicationException {
		return expenseDao.addExpense(expense);
	}
}
