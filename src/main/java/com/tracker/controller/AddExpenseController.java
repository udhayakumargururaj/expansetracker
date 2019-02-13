package com.tracker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.BO.ExpenseBO;
import com.tracker.Exceptions.ApplicationException;
import com.tracker.model.Expense;

@RestController
public class AddExpenseController {
	private ExpenseBO expenseBO = null;
	public AddExpenseController() {
		expenseBO = new ExpenseBO();
	}
	@PostMapping("/expense")
	public String addExpense(@RequestBody Expense expense) throws ApplicationException {
		String result = null;
		try{
			result = expenseBO.addExpense(expense);
		} catch(Exception e) {
			throw new ApplicationException(e.getMessage());
		}
		return result;
	}

}
