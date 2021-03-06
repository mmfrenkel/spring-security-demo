package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showhome() {
		return "home";  // corresponds to home.js page
	}
	
	@GetMapping("/leaders")
	public String leaderPage() {
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String systemsPage() {
		return "systems";
	}

}
