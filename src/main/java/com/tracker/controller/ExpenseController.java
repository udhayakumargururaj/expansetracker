package com.tracker.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.BO.ExpenseBO;
import com.tracker.Exceptions.ApplicationException;
import com.tracker.model.Expense;

@RestController
public class ExpenseController {
	private ExpenseBO expenseBO = null;
	public ExpenseController() {
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
	
	@GetMapping("/expense")
	public ArrayList<Expense> getExpenses() throws ApplicationException {
		ArrayList<Expense> result = null;
		try {
			result = expenseBO.getExpense();
		} catch(Exception e) {
			throw new ApplicationException(e.getMessage());
		}
		return result;
	}
}
