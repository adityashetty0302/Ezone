package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.SupplierDAO;

import com.model.Supplier;





@Controller
public class SupplierController 
{

	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="/admin/supplier",method=RequestMethod.GET)
	public String showSupplier(Model m)
	{
		List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
		m.addAttribute("suppmodel", new Supplier());
		return "Supplier";
	
	}
	
	@RequestMapping(value="/admin/AddSupplier",method=RequestMethod.POST)
	public String addSupplier(@ModelAttribute("suppmodel")Supplier supplier,Model m)
	{
		supplierDAO.addSupplier(supplier);
		
		List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
		m.addAttribute("suppmodel", new Supplier());
		
		
		return "Supplier";
	}
	
	@RequestMapping(value="/admin/deleteSupplier{supId}")
	public String deleteSupplier(@PathVariable("supId")int supId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supId);
		supplierDAO.deleteSupplier(supplier);
		List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
		m.addAttribute("suppmodel", new Supplier());
		
	
		return "Supplier";
	} 
	
	@RequestMapping(value="/admin/updateSupplier{supId}",method=RequestMethod.GET)
	public String updateSupplier(@PathVariable("supId") int supId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supId);
		m.addAttribute("suppmodel", supplier);
		
		List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
		
		
		
		
		return "UpdateSupplier";
	}
	
	@RequestMapping(value="/admin/UpdateSupplier",method=RequestMethod.POST)
	public String updateMySupplier(@ModelAttribute("suppmodel")Supplier supplier,Model m)
	{
		supplierDAO.updateSupplier(supplier);
		
		
		
		List<Supplier> listsupplier=supplierDAO.retrieveSupplier();
		m.addAttribute("supplierList",listsupplier);
		m.addAttribute("suppmodel", new Supplier());
		
		return "Supplier";
	}
	

	
}
