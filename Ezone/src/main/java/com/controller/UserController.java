package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.UserDAO;
import com.model.User;




@Controller
public class UserController {
	
	@Autowired
	UserDAO userDAO;

	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showUser(Model m)
	{
		
		m.addAttribute("usermodel", new User());
		return "Register";
	
	}
	
	
}
