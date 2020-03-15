package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/user-login")
	public String userLogin() {
		return "userLogin";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "accessDenied";
	}
}
