package com.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.SupplierDAO;
import com.hibernateConfig.hiberConfig;
import com.model.Supplier;



public class SupplierTest 
{

static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext(hiberConfig.class);
		configApplnContext.scan("com");
		//configApplnContext.refresh();
		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("hiberConfig.class");
		supplierDAO=(SupplierDAO)configApplnContext.getBean("supplierDAO");
	}
	
	
	@Ignore
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupId(101);
		supplier.setSupName("RetailNet");
		supplier.setSupAdd("Flipkart's Best Seller");
		
		assertTrue(supplierDAO.addSupplier(supplier));
	}
	
	//@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupId(101);
		supplier.setSupName("RetailNet");
		supplier.setSupAdd("Mumbai");
		
		assertTrue(supplierDAO.updateSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupId(103);
		
		assertTrue(supplierDAO.deleteSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void retrieveSupplierTest()
	{
		List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
		assertNotNull("Problem in Retriving ",listSupplier);
		this.show(listSupplier);
	}
	
	@Ignore
	public void show(List<Supplier> listSupplier)
	{
		for(Supplier supplier:listSupplier)
		{
			System.out.println("Supplier ID:"+supplier.getSupId());
			System.out.println("Supplier Name:"+supplier.getSupName());
		}
	}
	
	@Ignore
	@Test
	public void getSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(101);
		assertNotNull("Problem in Getting:",supplier);
		System.out.println("Supplier ID:"+supplier.getSupId());
		System.out.println("Supplier Name:"+supplier.getSupName());
		System.out.println("Supplier Address  = "+supplier.getSupAdd());
	}
	
}
