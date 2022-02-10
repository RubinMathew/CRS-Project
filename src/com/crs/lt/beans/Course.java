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
	private String instructor;
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
public String getInstructor() {
	return instructor;
}
public void setInstructor(String instructor) {
	this.instructor = instructor;
}


}
