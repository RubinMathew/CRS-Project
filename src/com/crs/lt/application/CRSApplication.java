package com.crs.lt.application;

import java.util.Scanner;


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
		System.out.println("1.CRS-Student-Application");
		System.out.println("2.Register Student");
		System.out.println("3.Log in");
		System.out.println("4.Exit");
		System.out.println("Enter your option:- ");
		Scanner sc=new Scanner(System.in);
		op=sc.nextInt();
		/* goto CRSAdmin,CRSStudent,CRSProfessor Menu from here */
		
		
		switch(op)
		{
		case 1:
				//goto student service
			
			break;
		case 2:
			//goto admin service
			break;
		case 3:
			//goto professor service
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
