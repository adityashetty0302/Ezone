package com.model;

import java.io.Serializable;

public class UserModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String name;
	String email;
	String role;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserModel [name=" + name + ", email=" + email + ", role=" + role + "]";
	}

		

}
