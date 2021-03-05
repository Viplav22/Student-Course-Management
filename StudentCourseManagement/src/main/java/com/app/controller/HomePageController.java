package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@GetMapping("/")
	public String provideWelcomePage() {
		System.out.println("in index page");
		return "/index";
	}
}
