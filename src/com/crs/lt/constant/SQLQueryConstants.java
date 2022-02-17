package com.crs.lt.constant;

public interface SQLQueryConstants {
	
	 public final String VIEW_COURSE_CATALOG="select courseCode,courseName,description from tbl_catalog";
	 public final String ADD_STUDENT_DETAILS="insert into tbl_student(branch,batch,emailid) values(?,?,?)";
	 public final String CREATE_USER_ACCOUNT="insert into tbl_user values(?,?,?,?,?)";
	
	 

}
