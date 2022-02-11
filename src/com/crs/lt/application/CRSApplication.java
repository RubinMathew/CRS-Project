package com.crs.lt.application;

import java.util.Scanner;

public class CRSApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//menus needs to be specified over here
		System.out.println("Welcome to Crs Application");
		System.out.println("1.CRS-Student-Application");
		System.out.println("2.CRS-Admin-Application");
		System.out.println("3.CRS-Professor-Application");
		System.out.println("4.Exit");
		Scanner sc=new Scanner(System.in);
		int op=sc.nextInt();
		/* goto CRSAdmin,CRSStudent,CRSProfessor Menu from here*/
		
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
	}

}
