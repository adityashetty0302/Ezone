package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean addUser(User user) 
	{
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
		
		
	}

}
