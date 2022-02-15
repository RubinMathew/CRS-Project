package com.crs.lt.beans;

import java.util.Date;

public class Professor extends User {
	
private String department;
private String designtion;
private Date dateofJoinig;
/* email id and professors ids are also available in the database  table */

public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getDesigntion() {
	return designtion;
}
public void setDesigntion(String designtion) {
	this.designtion = designtion;
}
public Date getDateofJoinig() {
	return dateofJoinig;
}
public void setDateofJoinig(Date dateofJoinig) {
	this.dateofJoinig = dateofJoinig;
}


}
