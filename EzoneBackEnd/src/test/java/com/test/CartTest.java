package com.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.CartDAO;
import com.hibernateConfig.hiberConfig;
import com.model.Cart;

public class CartTest 
{

	static CartDAO cartDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext(hiberConfig.class);
		configApplnContext.scan("com");
		//configApplnContext.refresh();
		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("hiberConfig.class");
		cartDAO=(CartDAO)configApplnContext.getBean("cartDAO");
	}
	
	
	@Ignore
	@Test
	public void addCartTest()
	{
		Cart cart=new Cart();
		cart.setOrderId(1002);
		cart.setProductId(1);
		cart.setQuantity(3);
		cart.setPrice(270000);
		cart.setName("Vinod");
		cart.setStatus("NP");
		cart.setProductName("Iphone X");
		
		assertTrue("Problem in Adding CartItem",cartDAO.addCart(cart));
	}
	
	@Ignore
	@Test 
	public void updateCartTest()
	{
		Cart cart=new Cart();
		cart.setCartItemId(4);
		cart.setOrderId(1001);
		cart.setProductId(1);
		cart.setQuantity(5);
		cart.setPrice(450000);
		cart.setName("Vinod");
		cart.setStatus("NP");
		cart.setProductName("Iphone X");
		assertTrue("Problem in Updating CartItem",cartDAO.updateCart(cart));
	}
	
	
	@Ignore
	@Test
	public void deleteCartTest()
	{
		Cart cart=new Cart();
		cart.setCartItemId(5);
		cart.setOrderId(1001);
		cart.setProductId(1);
		cart.setQuantity(3);
		cart.setPrice(270000);
		cart.setName("Vinod");
		cart.setStatus("NP");
		cart.setProductName("Iphone X");
		
		assertTrue("Problem in Deletion CartItem",cartDAO.deleteCart(cart));
	}
	
//	@Ignore
	@Test
	public void getCartItemsTest()
	{
		String name="Vinod";
		List<Cart> listCartItems=cartDAO.getCartItems(name);
		assertNotNull("Problem in Listing CartItem",listCartItems);
		this.showCartItem(listCartItems);
	}
	
	
	
	public void showCartItem(List<Cart> listCartItem)
	{
		for(Cart cart:listCartItem)
		{
			System.out.println("Order Id:"+cart.getOrderId());
			System.out.println("Product Name :"+cart.getProductName());
		}
	}
	
	
}
