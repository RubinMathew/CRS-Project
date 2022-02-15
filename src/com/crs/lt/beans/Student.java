package com.crs.lt.beans;

public class Student extends User {
	
private int studentId;
private String branch;
private int batch;
private boolean isApproved=false;

public boolean isApproved() {
	return isApproved;
}
public void setApproved(boolean isApproved) {
	this.isApproved = isApproved;
}
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public int getBatch() {
	return batch;
}
public void setBatch(int batch) {
	this.batch = batch;
}


}
