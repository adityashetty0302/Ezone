package com.dao;

import java.util.List;

import com.model.Supplier;

public interface SupplierDAO {

	public boolean addSupplier(Supplier supplier);

	public List<Supplier> retrieveSupplier();

	public boolean deleteSupplier(Supplier supplier);

	public Supplier getSupplier(int supId);

	public boolean updateSupplier(Supplier supplier);

}
