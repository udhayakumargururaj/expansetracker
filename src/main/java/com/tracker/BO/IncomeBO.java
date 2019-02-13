package com.tracker.BO;

import com.tracker.Exceptions.ApplicationException;
import com.tracker.dao.IIncome;
import com.tracker.daoImpl.IncomeDaoImpl;
import com.tracker.model.Income;

public class IncomeBO {
	private static IIncome incomeDao = null;
	public IncomeBO() {
		incomeDao = new IncomeDaoImpl(); 
	}
	public String addIncome(Income income) throws ApplicationException {
		return incomeDao.addIncome(income);
	}
}
