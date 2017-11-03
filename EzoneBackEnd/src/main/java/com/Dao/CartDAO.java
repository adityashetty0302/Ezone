package com.dao;

import java.util.List;

import com.model.Cart;

public interface CartDAO 
{
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public Cart getCartItem(int cartitemId); //Single CartItem
	public List<Cart> getCartItems(String username); //Multiple 
}
