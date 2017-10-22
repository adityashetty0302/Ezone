package com.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		List<Category> listCategory=categoryDAO.retrieveCategory();
		m.addAttribute("categoryList",listCategory);
		m.addAttribute("catmodel", new Category());
		return "Category";
	
	}
	
	@RequestMapping(value="/AddCategory",method=RequestMethod.POST)
	public String addCategory(@ModelAttribute("catmodel")Category category,Model m)
	{
		categoryDAO.addCategory(category);
		
		List<Category> listCategory=categoryDAO.retrieveCategory();
		m.addAttribute("categoryList",listCategory);
		m.addAttribute("catmodel", new Category());
		
		
		return "Category";
	}
	
	@RequestMapping(value="/deleteCategory{catId}")
	public String deleteCategory(@PathVariable("catId")int catId,Model m)
	{
		Category category=categoryDAO.getCategory(catId);
		categoryDAO.deleteCategory(category);
		List<Category> listCategory=categoryDAO.retrieveCategory();
		m.addAttribute("categoryList",listCategory);
		m.addAttribute("catmodel", new Category());
		
	
		return "Category";
	} 
	
//	@RequestMapping(value="/updateCategory{catId}",method=RequestMethod.GET)
//	public String updateCategory(@PathVariable("catId") int catId,Model m)
//	{
//		Category category=categoryDAO.getCategory(catId);
//		m.addAttribute("catmodel", category);
//		
//		List<Category> listCategory=categoryDAO.retrieveCategory();
//		m.addAttribute("categoryList",listCategory);
//		m.addAttribute("catmodel", category);
//		
//		
//		
//		return "UpdateCategory";
//	}
//	
//	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
//	public String updateMyCategory(@ModelAttribute("catmodel")Category category,Model m)
//	{
//		categoryDAO.updateCategory(category);
//		
//		Category category1=new Category();
//		m.addAttribute(category1);
//		
//		List<Category> listCategory=categoryDAO.retrieveCategory();
//		m.addAttribute("categoryList",listCategory);
//		
//		return "redirect:/category";
//	}
//	

}
