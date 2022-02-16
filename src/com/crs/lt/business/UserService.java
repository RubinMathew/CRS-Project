/**
 * 
 */
package com.crs.lt.business;

import com.crs.lt.dao.UserDAOOperation;

/**
 * @author user214
 *
 */
public class UserService implements UserServiceInterface{

	public int login(String username,String password){
		
		
		UserDAOOperation udo=new UserDAOOperation();
		int n=udo.loginProcess(username, password);
		return n;
	}
}
