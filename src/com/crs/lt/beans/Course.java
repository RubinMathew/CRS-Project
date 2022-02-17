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
	private int instructor; // foriegn key reference to professor table
	private String courseCode;
	private int courseId;
	private int availbleSeats;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getAvailbleSeats() {
		return availbleSeats;
	}
	public void setAvailbleSeats(int availbleSeats) {
		this.availbleSeats = availbleSeats;
	}

	
	
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
