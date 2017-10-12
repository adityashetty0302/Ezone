package com.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.CategoryDAO;
import com.hibernateConfig.hiberConfig;
import com.model.Category;

public class CategoryTest {

	
	
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext(hiberConfig.class);
		configApplnContext.scan("com");
		//configApplnContext.refresh();
		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("hiberConfig.class");
		categoryDAO=(CategoryDAO)configApplnContext.getBean("categoryDAO");
	}
	
	
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCatId(101);
		category.setCatName("Mobiles");
		category.setCatDesc("All Mobiles");
		
		assertTrue(categoryDAO.addCategory(category));
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=new Category();
		category.setCatId(103);
		category.setCatName("JMShirt");
		category.setCatDesc("John Miller Shirt with Best Price");
		
		assertTrue(categoryDAO.updateCategory(category));
	}
	
	//@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=new Category();
		category.setCatId(103);
		assertTrue(categoryDAO.deleteCategory(category));
	}
	
}
