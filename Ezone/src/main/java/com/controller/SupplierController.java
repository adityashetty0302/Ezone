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
	
	@RequestMapping(value="/supplier",method=RequestMethod.GET)
	public String showSupplier(Model m)
	{
		List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
		m.addAttribute("suppmodel", new Supplier());
		return "Supplier";
	
	}
	
	@RequestMapping(value="/AddSupplier",method=RequestMethod.POST)
	public String addSupplier(@ModelAttribute("suppmodel")Supplier supplier,Model m)
	{
		supplierDAO.addSupplier(supplier);
		
		List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
		m.addAttribute("suppmodel", new Supplier());
		
		
		return "Supplier";
	}
	
	@RequestMapping(value="/deleteSupplier{supId}")
	public String deleteSupplier(@PathVariable("supId")int supId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supId);
		supplierDAO.deleteSupplier(supplier);
		List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
		m.addAttribute("suppmodel", new Supplier());
		
	
		return "Supplier";
	} 
	

	
}
