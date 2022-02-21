package com.crs.lt.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.crs.lt.beans.Student;
import com.crs.lt.beans.User;
import com.crs.lt.constant.DBCRSConstants;
import com.crs.lt.constant.SQLQueryConstants;

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
				stmt = conn.prepareStatement(SQLQueryConstants.ADD_STUDENT_DETAILS);
				stmt.setString(1, student.getBranch());
				stmt.setInt(2, student.getBatch());
				stmt.setString(3, user.getEmailid());
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
				System.out.println(e);
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

	@Override
	public int findStudentId(String emailId) {

		Connection conn=null;
		PreparedStatement stmt=null;
		int studentid=0;
		
		try{
			Class.forName(DBCRSConstants.JDBC_DRIVER);
			conn=DriverManager.getConnection(DBCRSConstants.DB_URL,DBCRSConstants.USER,DBCRSConstants.PASS);	
			stmt = conn.prepareStatement(SQLQueryConstants.GET_STUDENT_ID);
			stmt.setString(1, emailId);
			ResultSet rs=stmt.executeQuery();
			
			
			
			while(rs.next()){
				studentid=rs.getInt("studentid");
			}
			stmt.close();
			conn.close();
			return studentid;
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return studentid;

	}

	@Override
	public boolean registerCourse(int studentId, int courseId) {
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try{
			Class.forName(DBCRSConstants.JDBC_DRIVER);
			conn=DriverManager.getConnection(DBCRSConstants.DB_URL,DBCRSConstants.USER,DBCRSConstants.PASS);	
			stmt = conn.prepareStatement(SQLQueryConstants.REGISTER_FOR_A_COURSE);
	
			
			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			int counter=stmt.executeUpdate();
			
		}catch(Exception e){
			
		}
		
		return false;
	}
	
}
