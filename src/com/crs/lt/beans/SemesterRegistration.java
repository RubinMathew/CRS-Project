/**
 * 
 */
package com.crs.lt.beans;

import java.util.Date;

/**
 * @author user214
 *
 */
public class SemesterRegistration {
	
	private int studentId;
	private int semester;
	private Date dateofRegistration;
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public Date getDateofRegistration() {
		return dateofRegistration;
	}
	public void setDateofRegistration(Date dateofRegistration) {
		this.dateofRegistration = dateofRegistration;
	}

	
	
}
