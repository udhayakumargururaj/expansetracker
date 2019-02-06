package com.tracker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.BO.RegisterBO;
import com.tracker.Exceptions.ApplicationException;
import com.tracker.model.Register;

@RestController
public class RegisterController {
	private RegisterBO registerBO = null;
	public RegisterController() {
		registerBO = new RegisterBO();
	}
	
	@PostMapping("/register")
	public String addNewUser(@RequestBody Register userInfo) {
		String result = null;
		try {
			result = registerBO.addNewUser(userInfo);
		} catch(ApplicationException exception) {
			exception.printStackTrace();
		}catch (Exception e) {
			result = "Issue on Document Insert";
			e.printStackTrace();
		}
		return result;
	}
}
