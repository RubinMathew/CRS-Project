package com.crs.lt.application;

import java.util.Scanner;
import com.crs.lt.business.StudentService;
import com.crs.lt.business.UserService;

public class CRSApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//menus needs to be specified over here
				int op=0;
				Scanner sc=new Scanner(System.in);
				do{
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++\n");
				System.out.println("\nWelcome to CRS Application");
				System.out.println("1.Register Student");
				System.out.println("2.Log in");
				System.out.println("3.Update Password");
				System.out.println("4.Exit");
				System.out.println("Enter your option:- ");
				
				op=sc.nextInt();
			
				
				switch(op)
				{

				case 1:
					//goto student registration form
					new StudentService().register();
					
					break;
				case 2:
					//do login work here 
					System.out.println("Enter the user name(Emaild ID) :- \n");
					String username=sc.next().trim();
					System.out.println("Enter the password :- \n");
					String password=sc.next().trim();
					System.out.println(username+";"+password);
					sc.next();
					int userloginoption=new UserService().login(username, password);
					switch(userloginoption){
					case 1:
						System.out.println("You will be redirected to admin home page (press any character to continue then enter key )\n");
						sc.next();
						CRSAdminApplication.showAdminHome(username);
						break;
					case 2:
						System.out.println("You will be redirected to professor home page (press any character to continue then enter key )\n");
						sc.next();
						CRSProfessorApplication.showProfessorHome(username);
						break;
					case 3:
						System.out.println("You will be redirected to student home page (press any character to continue then enter key )\n");
						sc.next();
						CRSStudentApplication.showStudentHome(username);
						break;
					}
					
					
					
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
		sc.close();
	}

}
