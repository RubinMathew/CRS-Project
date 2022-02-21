package com.crs.lt.dao;

import com.crs.lt.beans.User;

public interface UserDAOInterface {

	public boolean addUserAccount(User user);
	public int loginProcess(String username, String password);

}
