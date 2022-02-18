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
	public static void showStudentHome(String emailid) {
		// TODO Auto-generated method stub
		// student menu will be designed here using do while loop
		System.out.println("CRS Student Application ");
		System.out.println("Logged in as : Student");
		
		int studentid=0;
		studentid=new StudentService().getStudentId(emailid);
		
		System.out.println("Student Id: "+studentid);
		StudentService ss= new StudentService(); 
		Scanner sc=new Scanner(System.in);
		System.out.println("1. View Courses");
		System.out.println("2. Register a Course ");
		System.out.println("3. Vew Registered Courses");
		System.out.println("4. Drop Course");
		System.out.println("0. Logout ");
		System.out.println("Enter your option : -  ");
		int op=sc.nextInt();
		switch (op) {
		case 0:
			return;
			
		case 1:
			try{
				ss.viewCourses();
			}
			catch (Exception e) {
				// TODO: handle exception
				
			}
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
