package com.tracker.BO;

import com.tracker.Exceptions.ApplicationException;
import com.tracker.dao.IRegister;
import com.tracker.daoImpl.RegisterDaoImpl;
import com.tracker.model.Register;
import com.tracker.validator.RegisterValidator;

public class RegisterBO {
private static IRegister registerDao = null;
	
	public RegisterBO() {
		registerDao = new RegisterDaoImpl(); 
	}
	public String addNewUser(Register register) throws ApplicationException {
		String result = null;
			if(RegisterValidator.validateRegistration(register)) {
				 result = registerDao.addNewUser(register);
			} else {
				throw new ApplicationException("Validation Error from Application");
			}
		return result;
	}
}
