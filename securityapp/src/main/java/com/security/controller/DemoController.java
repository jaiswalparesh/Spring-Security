package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/leader")
	public String showLeader() {
		return "leader";
	}

	@GetMapping("/system")
	public String showSystem() {
		return "system";
	}
}
