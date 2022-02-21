package com.crs.lt.constant;

public interface SQLQueryConstants {
	
	 public final String VIEW_COURSE_CATALOG="select courseCode,courseName,description from tbl_catalog";
	 public final String ADD_STUDENT_DETAILS="insert into tbl_student(branch,batch,emailid) values(?,?,?)";
	 public final String CREATE_USER_ACCOUNT="insert into tbl_user values(?,?,?,?,?)";
	 public final String ALL_AVAILABLE_COURSES="SELECT * FROM tbl_course WHERE isOffered=1";
	 public final String GET_STUDENT_ID="SELECT studentid FROM tbl_student WHERE emailid=?";
	 public final String REGISTER_FOR_A_COURSE="insert into tbl_registeredcourses(studentId,courseId) values(?,?)";
	 public final String CHECK_COURSE_AVAILABLE="SELECT count(*)  as Number  from  tbl_course where courseId=? AND isOffered=1";
	 public final String UPDATE_NO_SEATS="update tbl_course set availableSeats=availableSeats-1 where courseId=?";
	 public final String UPDATE_COURSE_STATUS="update tbl_course set isOffered=0 where availableSeats <=0";
}
