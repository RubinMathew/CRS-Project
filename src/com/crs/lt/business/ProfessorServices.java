package com.crs.lt.business;

import org.apache.log4j.Logger;

public class ProfessorServices implements ProfessorServiceInterface {
	private static Logger logger = Logger.getLogger(ProfessorServices.class);
	
	public void  viewEnrolledStudets() {
		System.out.println("Viewing Enrolled Students");
	}
	public void  addGrade() {
		System.out.println("adding/updating grades");
	}
}
