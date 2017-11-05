package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dao.UserDAO;
import com.model.User;
import com.model.UserModel;

@ControllerAdvice
public class GlobalController {

	@Autowired
	HttpSession session;

	@Autowired
	UserDAO userDAO;

	UserModel userModel = null;

	@ModelAttribute("userModel")
	public UserModel getUserModel() {

		if (session.getAttribute("userModel") == null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			User user = userDAO.getUser(authentication.getName());
			if (user != null) {

				userModel = new UserModel();

				userModel.setName(user.getName());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setPhone(user.getPhone());
				userModel.setAddress(user.getAddress());
				userModel.setCountry(user.getCountry());

				session.setAttribute("userModel", userModel);

				return userModel;

			}
		}

		return (UserModel) session.getAttribute("userModel");
	}
}
