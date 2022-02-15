/**
 * 
 */
package com.crs.lt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.crs.lt.beans.User;
import com.crs.lt.constant.DBCRSConstants;

/**
 * @author user214
 *
 */
public class UserDAOOperation implements UserDAOInterface {

	public boolean addUserAccount(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
		
			Class.forName(DBCRSConstants.JDBC_DRIVER);
			conn=DriverManager.getConnection(DBCRSConstants.DB_URL);
			String sql = "insert into tbl_user values(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getEmailid());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getRole());
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}

}
