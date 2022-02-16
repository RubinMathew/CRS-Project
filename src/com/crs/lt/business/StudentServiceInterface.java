package com.crs.lt.business;

public interface StudentServiceInterface {

	public boolean changePassword(int studentId, String currentPassword,String newPassword);/*Completed*/
	public void register(); /*Completed*/
	public void viewCard();
	/* implementation will be followed */
	public void registerCourse(int studentId); // completed
	public void addCourse(String courseCode,int studentID); // completed
	public void dropcourse(int studentid,String courseCode,int semesterID); //completed
	public void viewCourses(); // completed
	public void viewRegisteredCourses(int studentId); //completed
	public void viewGradeCard(int studentId,int semesterId); //completed
	public void payment();
	

	
}
