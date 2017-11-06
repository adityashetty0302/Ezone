package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.CategoryDAO;
import com.model.Category;

@Controller
public class IndexController {
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping(value = "/")
	public String show() {
//		List<Category> listCategory = categoryDAO.retrieveCategory();
//		m.addAttribute("categoryList", listCategory);
		return "index";
	}

	@RequestMapping(value = "/error")
	public String error() {

		return "error";
	}

}
