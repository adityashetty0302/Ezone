package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CategoryDAO;
import com.model.Category;




@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional
	public boolean addCategory(Category category) {
		
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.save(category);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
		
	}

	public List<Category> retrieveCategory() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public boolean deleteCategory(Category category) {
		try
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;	
		}
		
	}

	public Category getCategory(int catId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public boolean updateCategory(Category category) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
		
	}
	
	
}
