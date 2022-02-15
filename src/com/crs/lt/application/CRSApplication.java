package com.crs.lt.application;

import java.util.Scanner;

import com.crs.lt.business.StudentService;


public class CRSApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//menus needs to be specified over here
		int op=0;
		do{
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\nWelcome to CRS Application");
		System.out.println("1.Register Student");
		System.out.println("2.Log in");
		System.out.println("3.View Courses");
		System.out.println("4.Exit");
		System.out.println("Enter your option:- ");
		Scanner sc=new Scanner(System.in);
		op=sc.nextInt();
		/* goto CRSAdmin,CRSStudent,CRSProfessor Menu from here */
		
		
		switch(op)
		{
		
				//goto student service
			
		
		case 1:
			//goto student registration form
			new StudentService().register();
			
			break;
		case 2:
			//goto professor service
			break;
		case 3:
			break;
		case 4:
			break;
		default:
			System.out.println("You have entered wrong option");
			sc.next();
		}
	} while(op!=4);
	}

}
