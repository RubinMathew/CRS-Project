/**
 * 
 */
package com.crs.lt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crs.lt.beans.User;
import com.crs.lt.constant.DBCRSConstants;

/**
 * @author user214
 * 
 */
public class UserDAOOperation implements UserDAOInterface {

	public boolean addUserAccount(User user) {
		// Adding data to tbl_user first
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			Class.forName(DBCRSConstants.JDBC_DRIVER);
			conn = DriverManager.getConnection(DBCRSConstants.DB_URL,
					DBCRSConstants.USER, DBCRSConstants.PASS);
			String sql = "insert into tbl_user values(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getEmailid());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getPassword());
			stmt.setInt(4, user.getRole());
			stmt.setBoolean(5, user.isApproved());

			int j = stmt.executeUpdate();
			stmt.close();
			conn.close();
			if (j > 0) {

				return true;

			}
			if (j <= 0) {

				return false;

			}

		} catch (Exception e) {
			// TODO: handle exception
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			return false;
		}
		return false;

	}

	public int loginProcess(String username, String password){
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			Class.forName(DBCRSConstants.JDBC_DRIVER);
			conn = DriverManager.getConnection(DBCRSConstants.DB_URL,DBCRSConstants.USER, DBCRSConstants.PASS);
			String sql="SELECT * FROM tbl_user where emailid=? and password=? and isApproved=1";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, username.trim());
			stmt.setString(2, password.trim());
			ResultSet rs = stmt.executeQuery(sql); 
			int loginapprovecounter=0;
			while(rs.next()){
				loginapprovecounter++;
			}
			stmt.close();
			conn.close();
			if(loginapprovecounter>0){
				return 1;
				
			}
			else{
				return 0;
			}
					
		}catch (Exception e) {
			// TODO: handle exception
			
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return 0;
			}
		
		}
		
		return 0;
	}
}
