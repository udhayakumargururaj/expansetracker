package com.tracker.BO;

import com.tracker.Exceptions.ApplicationException;
import com.tracker.dao.IRegister;
import com.tracker.daoImpl.RegisterDaoImpl;
import com.tracker.model.Register;

public class RegisterBO {
private static IRegister registerDao = null;
	
	public RegisterBO() {
		registerDao = new RegisterDaoImpl(); 
	}
	public String addNewUser(Register register) throws ApplicationException {
		return registerDao.addNewUser(register);
	}
}
