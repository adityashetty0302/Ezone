package com.dao;

import com.model.*;

public interface UserDAO {
	public boolean addUser(User user);

	public User getUser(String email);

}
