package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public String loginPage(@RequestParam(name = "error", required = false) String error, Model m) {
		if (error != null) {
			m.addAttribute("message", "Invalid Username or password");
		}

		return "Login";
	}

}
