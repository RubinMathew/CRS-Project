package com.crs.lt.dao;

import com.crs.lt.beans.Student;

public interface StudentDAOInterface {
	//this method is for registering the student on tbl_student 
	public boolean registerStudent(Student student);
	public int findStudentId(String emailId);
	public boolean registerCourse(int studentId,int courseId);
	

		
	

}
