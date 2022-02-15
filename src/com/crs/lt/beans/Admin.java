package com.crs.lt.beans;

import java.util.Date;

public class Admin extends User {

	private Date dateOfJoining;
	//adminid int 32 in database tbl_admin
	//emailid varchar 32 in database tbl_admin
	
	
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public void addCourses()
	{
		
	}


	

}
