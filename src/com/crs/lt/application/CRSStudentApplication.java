/**
 * 
 */
package com.crs.lt.application;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
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
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		Month month = localDate.getMonth();
		int date = localDate.getDayOfMonth();
		int year = localDate.getYear();
		int second =localTime.getSecond();
		int minute = localTime.getMinute();
		int hour = localTime.getHour();
		int op;
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println("CRS Student Application ");
		System.out.println("Logged in as : Student");
		System.out.println("Logged in date: "+ date+ " "+ month+" " + year);
		System.out.println("Logged in time: "+hour+ ":"+ minute+":" + second);
		int studentid=0;
		studentid=new StudentService().getStudentId(emailid);
		
		System.out.println("Student Id: "+studentid);
		StudentService ss= new StudentService(); 
		
		System.out.println("1. View Courses");
		System.out.println("2. Register a Course ");
		System.out.println("3. Vew Registered Courses");
		System.out.println("4. Drop Course");
		System.out.println("0. Logout ");
		System.out.println("Enter your option : -  ");
		 op=sc.nextInt();
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
			
			ss.addCourse(studentid);
			break;
		case 3:
			ss.viewRegisteredCourses(studentid);
			break;
		default:
			break;
		}
	}while(op!=0);
		sc.close();

}}