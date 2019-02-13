package com.tracker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.BO.IncomeBO;
import com.tracker.Exceptions.ApplicationException;
import com.tracker.model.Income;

@RestController
public class IncomeController {
	private IncomeBO incomeBO = null;
	public IncomeController() {
		incomeBO = new IncomeBO();
	}
	@PostMapping("/income")
	public String addExpense(@RequestBody Income income) throws ApplicationException {
		String result = null;
		try{
			result = incomeBO.addIncome(income);
		} catch(Exception e) {
			throw new ApplicationException(e.getMessage());
		}
		return result;
	}

}
