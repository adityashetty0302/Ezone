package com.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.CategoryDAO;
import com.Dao.ProductDAO;
import com.hibernateConfig.hiberConfig;
import com.model.Product;


public class ProductTest 
{
	static ProductDAO productDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext(hiberConfig.class);
		configApplnContext.scan("com");
		//configApplnContext.refresh();
		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("hiberConfig.class");
		productDAO=(ProductDAO)configApplnContext.getBean("productDAO");
	}
	
	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductId(101);
		product.setProductName("Samsung J5");
		product.setProductDesc("Mobile with NFC and 4G");
		product.setStock(10);
		product.setPrice(7000);
		product.setCatId(101);
		product.setSupId(101);
		
		assertTrue("Problem in Insertion",productDAO.addProduct(product));
		
	}

}
