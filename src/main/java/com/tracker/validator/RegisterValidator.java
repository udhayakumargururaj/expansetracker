package com.tracker.validator;

import com.tracker.model.Register;

public class RegisterValidator {
	private static final String MOBILE_REGEX = "^([\\d]{11})([^A-Za-z])$";
	private static final String EMAIL_REGEX = "^(([\\w-\\s]+)|([\\w-]+(?:\\.[\\w-]+)*)|([\\w-\\s]+)([\\w-]+(?:\\.[\\w-]+)*))(@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$)|(@\\[?((25[0-5]\\.|2[0-4][0-9]\\.|1[0-9]{2}\\.|[0-9]{1,2}\\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\]?$)";
	public static boolean validateRegistration(Register register) {
		String mobileNo = register.getMobileNumber();
		String email = register.getEmail();
		/*String userName = register.getUserName();
		String password = register.getPassword();*/
		
		return validate(MOBILE_REGEX, mobileNo) && validate(EMAIL_REGEX, email);
	}
	
	private static boolean validate(String rule, String value) {
		boolean isValidate = false;
		isValidate = value.matches(rule);		
		return isValidate;
	}
	
	/*public static void main(String[] args) {
		Register register = new Register();
		register.setEmail("test@gmail.com");
		register.setMobileNumber("919976086356");
		System.out.println(RegisterValidator.validateRegistration(register));
	}*/

}
