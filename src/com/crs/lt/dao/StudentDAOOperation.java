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

import crs.lt.exceptions.CourseNotFoundException;

public class StudentDAOOperation implements StudentDAOInterface {

	@Override
	public boolean registerStudent(Student student) {
		// TODO Auto-generated method stub
		// add details to user account table tbl_user first
		Connection conn = null;
		PreparedStatement stmt = null;
		User user = new User();
		user.setEmailid(student.getEmailid());
		user.setName(student.getName());
		user.setPassword(student.getPassword());
		user.setRole(student.getRole());
		user.setApproved(false);
		boolean flag = new UserDAOOperation().addUserAccount(user);
		if (flag) {

			try {

				Class.forName(DBCRSConstants.JDBC_DRIVER);
				conn = DriverManager.getConnection(DBCRSConstants.DB_URL, DBCRSConstants.USER, DBCRSConstants.PASS);
				stmt = conn.prepareStatement(SQLQueryConstants.ADD_STUDENT_DETAILS);
				stmt.setString(1, student.getBranch());
				stmt.setInt(2, student.getBatch());
				stmt.setString(3, user.getEmailid());
				int j = stmt.executeUpdate();
				stmt.close();
				conn.close();
				if (j > 0) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				try {
					stmt.close();
					conn.close();
					return false;
				} catch (Exception e1) {
					// TODO: handle exception
					return false;
				}

			}

		}

		return false;

	}

	@Override
	public int findStudentId(String emailId) {

		Connection conn = null;
		PreparedStatement stmt = null;
		int studentid = 0;

		try {
			Class.forName(DBCRSConstants.JDBC_DRIVER);
			conn = DriverManager.getConnection(DBCRSConstants.DB_URL, DBCRSConstants.USER, DBCRSConstants.PASS);
			stmt = conn.prepareStatement(SQLQueryConstants.GET_STUDENT_ID);
			stmt.setString(1, emailId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				studentid = rs.getInt("studentid");
			}
			stmt.close();
			conn.close();
			return studentid;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return studentid;

	}

	@Override
	public boolean registerCourse(int studentId, int courseId) {
		Connection conn = null;
		PreparedStatement stmt = null, stmt2 = null, stmt3=null, stmt4=null;
		int counter = 0;

		try {
			Class.forName(DBCRSConstants.JDBC_DRIVER);
			conn = DriverManager.getConnection(DBCRSConstants.DB_URL, DBCRSConstants.USER, DBCRSConstants.PASS);
			/* check if the course with the specified course id  is available */
			stmt2 = conn.prepareStatement(SQLQueryConstants.CHECK_COURSE_AVAILABLE);
			stmt2.setInt(1, courseId);
			ResultSet rs = stmt2.executeQuery();
			int flag = 0;
			while (rs.next()) {
				flag = 1;
			}
			stmt2.close();
			/* Registering for a course */ 
			
			if (flag == 1) {
				stmt = conn.prepareStatement(SQLQueryConstants.REGISTER_FOR_A_COURSE);
				stmt.setInt(1, studentId);
				stmt.setInt(2, courseId);
				counter = stmt.executeUpdate();
				stmt.close();
				if(counter>0)
				{
					stmt3=conn.prepareStatement(SQLQueryConstants.UPDATE_NO_SEATS);
					int p=stmt3.executeUpdate();
					stmt3.close();
					if(p>0)
					{
						stmt4=conn.prepareStatement(SQLQueryConstants.UPDATE_COURSE_STATUS);
						stmt4.executeUpdate();
						stmt4.close();
						
					}
					
				}
			}
			conn.close();
			if (counter > 0) {
				return true;
			} else {
				throw new CourseNotFoundException("The course is not available");
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

}
