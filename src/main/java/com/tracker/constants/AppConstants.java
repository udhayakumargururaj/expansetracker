package com.tracker.constants;

public interface AppConstants {

	// Application error message
	
	String APP_ERROR_MESSAGE = "There are some issues on inserting the document";
	
	// Collection Name 
	String COL_EXPENSE = "expense";
	String COL_INCOME = "income";
	String COL_REGISTER="register";
	String COL_AUTH="authentication";
	
	// Expense Collection details
	
	String EXP_FIELD_CATEGORY = "category";
	String EXP_FIELD_NOTES = "notes";
	String EXP_FIELD_AMOUNT = "amount";
	String EXP_SUCCESS_MESSAGE = "expense added successfully";
	
	// Income Collection details
	
	String INC_FIELD_SALARY = "salary";
	String INC_FIELD_MONTH = "month";
	String INC_SUCCESS_MESSAGE = "income added successfully";
	
	// Register Collection details
	
	String REG_FIELD_MOBILE = "mobile";
	String REG_FIELD_USERNAME="username";
	String REG_FIELD_EMAIL = "email";
	String REG_FIELD_PASSWORD = "password";
	String REG_SUCCESS_MESSAGE = "User added successfully";
	
	// Authentication Collection details
	
	String AUTH_FIELD_USERNAME = "username";
	String AUTH_FIELD_PASSWORD = "password";
	
	
	
}