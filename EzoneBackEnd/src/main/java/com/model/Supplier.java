package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier 
{

	@Id
	int supId;
	
	String supName,supAdd;

	public int getSupId() {
		return supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getSupAdd() {
		return supAdd;
	}

	public void setSupAdd(String supAdd) {
		this.supAdd = supAdd;
	}

	
	

}
