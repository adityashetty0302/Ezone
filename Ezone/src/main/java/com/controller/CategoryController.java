package com.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.CategoryDAO;
import com.model.Category;



@Controller
public class CategoryController 
{

	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping(value="/category",method=RequestMethod.GET)
	public String showCategory(Model m)
	{
		Category category=new Category();
		m.addAttribute(category);
		
		List<Category> listCategory=categoryDAO.retrieveCategory();
		m.addAttribute("categoryList",listCategory);
		return "Category";
	
	}
	
	
	
}
