package com.tracker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.BO.UserBO;
import com.tracker.model.User;

@RestController
public class AuthController {
	private UserBO userBO = null;
	
	public AuthController() {
		userBO = new UserBO();
	}
	@PostMapping("/auth")
	public boolean authenticate(@RequestBody User userDetail){
		return userBO.authenticate(userDetail);
	}

}
