package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		return "bootstrap-login";
	}
	
	// adding request mapping for "/access-denied"
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		return "access-denied";
	}
}
