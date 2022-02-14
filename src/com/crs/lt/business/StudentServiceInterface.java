package com.crs.lt.business;

public interface StudentServiceInterface {

	public void changePassword();
	public void register();
	public void viewCard();
	/* implementation will be followed */
	public void registerCourse(int studentId);
	public void addCourse();
	public void dropCourse();
	public void viewCourses();
	public void viewRegisteredCourses(int studentId);
	public void viewGradeCard(int studentId,int semesterId);
	public void payment();
	public boolean changePassword(int studentId,String currentPassword,String newPassword);
	
}
