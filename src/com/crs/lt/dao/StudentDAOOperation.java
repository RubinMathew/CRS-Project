package com.crs.lt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.crs.lt.beans.Student;
import com.crs.lt.beans.User;
import com.crs.lt.constant.DBCRSConstants;

public class StudentDAOOperation implements StudentDAOInterface{

	public boolean registerStudent(Student student) {
		// TODO Auto-generated method stub
		 //add details to user account table tbl_user first
		Connection conn=null;
		PreparedStatement stmt=null;
		 
		User user=new User();
		user.setEmailid(student.getEmailid());
		user.setName(student.getName());
		user.setPassword(student.getPassword());
		user.setRole(student.getRole());
		user.setApproved(false);
		
	
		boolean flag=new UserDAOOperation().addUserAccount(user);
		if(flag){
			
			try{
				Class.forName(DBCRSConstants.JDBC_DRIVER);
				conn=DriverManager.getConnection(DBCRSConstants.DB_URL,DBCRSConstants.USER,DBCRSConstants.PASS);
				String sql = "insert into tbl_student values(?,?,?,?)";
				stmt = conn.prepareStatement(sql);
				stmt.setString(2, student.getBranch());
				stmt.setInt(3, student.getBatch());
				stmt.setString(4, user.getEmailid());
				int j=stmt.executeUpdate();
				stmt.close();
				conn.close();
				if(j>0)
				{
					return true;
				}
				else{
					return false;
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				try{
					stmt.close();
					conn.close();
					return false;
				}catch (Exception e1) {
					// TODO: handle exception
					return false;
				}
				
				
			}
			
		}
	
		
		return false;
		
		
	}

}
