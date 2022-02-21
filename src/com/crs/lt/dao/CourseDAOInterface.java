package com.crs.lt.dao;

import java.util.List;

import com.crs.lt.beans.Course;

public interface CourseDAOInterface {
	public boolean courseAvailable(int courseId);
	public List<Course> getAvailableCourses();


}
