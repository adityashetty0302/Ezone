package com.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CategoryDAO;
import com.dao.ProductDAO;
import com.hibernateConfig.hiberConfig;
import com.model.Product;
import com.model.Supplier;


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
	
	
//	@Test
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
	
//	@Test
	public void retrieveProductTest()

	
	{
		List<Product> listProducts=productDAO.retrieveProducts();
		
		assertTrue("List is Empty",listProducts.size()>0);
		
		for(Product product:listProducts)
		{
			System.out.println("Product ID:"+product.getProductId());
			System.out.println("Product Name:"+product.getProductName());
			System.out.println("Product Desc"+product.getProductDesc());
		}
	}
	
	@Test
	public void getProductTest()
	{
		Product product=productDAO.getProduct(1);
		assertNotNull("Problem in Getting:",product);
		System.out.println("Product ID:"+product.getProductId());
		System.out.println("Product Name:"+product.getProductName());
		System.out.println("Product Desc  = "+product.getProductDesc());
	}
	

}
