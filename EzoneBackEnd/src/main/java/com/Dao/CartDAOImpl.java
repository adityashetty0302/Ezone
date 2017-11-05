package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Cart;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean addCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
			return false;
		}
	}

	@Transactional
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
			return false;
		}

	}

	@Transactional
	public boolean deleteCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
			return false;
		}
	}

	public Cart getCartItem(int productId, String name) {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Cart.class);
		criteria.add(Restrictions.eq("productId", productId));
		criteria.add(Restrictions.eq("name", name));
		Cart cart = (Cart) criteria.uniqueResult();
		// Cart cart=(Cart)session.get(Cart.class,productId,name);
		session.close();
		return cart;
	}

	public List<Cart> getCartItems(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where name=:name");
		query.setParameter("name", name);
		List<Cart> listCartItem = query.list();
		session.close();
		return listCartItem;
	}

}