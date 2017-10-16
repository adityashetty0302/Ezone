package com.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Supplier;



@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	

	@Transactional
	public boolean addSupplier(Supplier supplier) {
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.save(supplier);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
		
	}

	public List<Supplier> retrieveSupplier() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> listSupplier=query.list();
		session.close();
		return listSupplier;
		
	}
	
	@Transactional
	public boolean deleteSupplier(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;	
		}
		
	}


	public Supplier getSupplier(int supId) {
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,supId);
		session.close();
		return supplier;
		
	}

	@Transactional
	public boolean updateSupplier(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
		
		
	}
	
	
}

