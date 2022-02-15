package com.crs.lt.dao;

import com.crs.lt.beans.Student;
import com.crs.lt.beans.User;

public class StudentDAOOperation implements StudentDAOInterface{

	public void registerStudent(Student student) {
		// TODO Auto-generated method stub
		 //add for user registration
		 
		User u=new User();
		u.setEmailid(student.getEmailid());
		u.setName(student.getName());
		u.setPassword(student.getPassword());
		u.setRole(student.getRole());
		u.setApproved(false);
		
		
	}

}
