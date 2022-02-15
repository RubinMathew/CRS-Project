/**
 * 
 */
package com.crs.lt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			conn=DriverManager.getConnection(DBCRSConstants.DB_URL,DBCRSConstants.USER,DBCRSConstants.PASS);
			String sql = "insert into tbl_user values(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getEmailid());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getPassword());
			stmt.setInt(4, user.getRole());
			stmt.setBoolean(5, user.isApproved());
		
			int j=stmt.executeUpdate();
			if(j<=0)
			{
				stmt.close();
				conn.close();
				return false;
				
			}
			stmt.close();
			conn.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		finally{
			try {
				if(stmt!=null)
					stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				return false;
			}
			try {
				if(conn!=null)
					stmt.close();
			} catch (SQLException se2) {
				// TODO: handle exception
				return false;
			}
		}
		
		return true;
	}

}
