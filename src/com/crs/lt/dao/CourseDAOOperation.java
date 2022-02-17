package com.crs.lt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crs.lt.beans.Course;
import com.crs.lt.constant.DBCRSConstants;
import com.crs.lt.constant.SQLQueryConstants;

public class CourseDAOOperation implements CourseDAOInterface{

	public List<Course> getAvailableCourses(){
		Connection conn=null;
		PreparedStatement stmt=null;
		List<Course> courseList=new ArrayList<Course>();
		try{
			Class.forName(DBCRSConstants.JDBC_DRIVER);
			conn = DriverManager.getConnection(DBCRSConstants.DB_URL,DBCRSConstants.USER, DBCRSConstants.PASS);			
			stmt = conn.prepareStatement(SQLQueryConstants.ALL_AVAILABLE_COURSES);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()){
				Course crs=new Course();
				crs.setCourseId(rs.getInt("courseId"));
				crs.setCourseName(rs.getString("courseName"));
				crs.setCourseCode(rs.getString("courseCode"));
				crs.setInstructor(rs.getInt("instructor"));
				crs.setOffered(rs.getBoolean("isOffered"));
				crs.setAvailbleSeats(rs.getInt("availableSeats"));
				courseList.add(crs);
			
			}
			stmt.close();
			conn.close();
			if(courseList.isEmpty()){
			return null;
			}
			
				
			
			
		}catch (Exception e) {
			// TODO: handle exception
			
		}
		
		return courseList;
	}
}
