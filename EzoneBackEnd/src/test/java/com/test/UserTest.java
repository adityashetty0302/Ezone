package com.test;




import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.UserDAO;
import com.hibernateConfig.hiberConfig;
import com.model.Category;
import com.model.User;

public class UserTest {
	
	static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext(hiberConfig.class);
		configApplnContext.scan("com");
		//configApplnContext.refresh();
		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("hiberConfig.class");
		userDAO=(UserDAO)configApplnContext.getBean("userDAO");
	}
	
	
	
	@Test
	public void addUserTest()
	{
		User user=new User();
		user.setEmail("b");
		user.setPassword("b");
		user.setName("Aditya Shetty");
		user.setAddress("Mumbai");
		user.setCountry("India");
		user.setPhone("984651684689");
		user.setRole("ROLE_ADMIN");
		user.setEnabled(true);
		
		assertTrue(userDAO.addUser(user));
	}
	
	
	
//	@Test
	public void getUserTest()
	{
		User user=userDAO.getUser("a");
		assertNotNull("Problem in Getting:",user);
		System.out.println("User Name:"+user.getName());
		
	}

}
