/**
 * 
 */
package com.crs.lt.application;

import java.util.Scanner;

import com.crs.lt.business.StudentService;

/**
 * @author user214
 *
 */
public class CRSStudentApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// student menu will be designed here using do while loop
		System.out.println("CRS Student Application ");
		System.out.println("Logged in as : Student");
		StudentService ss= new StudentService(); 
		Scanner sc=new Scanner(System.in);
		System.out.println("1. View Courses");
		System.out.println("2. Add Courses");
		System.out.println("3. Vew Registered Courses");
		System.out.println("4. drop Course");
		System.out.println("Enter your option : -  ");
		int op=sc.nextInt();
		switch (op) {
		case 1:
			ss.viewCourses();
			break;
		case 2:
			ss.addCourse("course1", 100);
			break;
		case 3:
			ss.viewRegisteredCourses(100);
			break;
		default:
			break;
		}
	}

}
