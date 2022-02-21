package com.crs.lt.business;

import org.apache.log4j.Logger;

public class AdminService implements AdminServiceInterface{

	private static Logger logger = Logger.getLogger(StudentService.class);
	public void addProfessor() {
		System.out.println("Adding Professor");
		
	}
	public void assignCourse() {
		System.out.println("Adding Course");
		
	}
	public void approveStudents() {
		System.out.println("Approving Students");
		
	}
	
}
