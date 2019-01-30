package com.tracker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.model.User;

@RestController
public class AuthController {
	
	@PostMapping("/auth")
	public boolean authenticate(@RequestBody User userDetail){
		System.out.println("Inside authentication Method "+userDetail.getUserName());
		return false;
	}

}
