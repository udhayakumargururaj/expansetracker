package com.tracker.dao;

import com.tracker.Exceptions.ApplicationException;
import com.tracker.model.Register;

public interface IRegister {
	
	public String addNewUser(Register register) throws ApplicationException;
	

}
