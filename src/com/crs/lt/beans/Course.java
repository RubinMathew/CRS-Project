/**
 * 
 */
package com.crs.lt.beans;

/**
 * @author user214
 *
 */

public class Course {
	
	private String courseName;
	private boolean isOffered;
	private int instructor; // foriegn key refeerence to professor table
	private String courseCode;
	
public String getCourseCode() {
	return courseCode;
}
public void setCourseCode(String courseCode) {
	this.courseCode = courseCode;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public boolean isOffered() {
	return isOffered;
}
public void setOffered(boolean isOffered) {
	this.isOffered = isOffered;
}
public int getInstructor() {
	return instructor;
}
public void setInstructor(int instructor) {
	this.instructor = instructor;
}


}
