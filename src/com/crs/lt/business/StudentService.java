/**
 * 
 */
package com.crs.lt.business;

import java.util.List;

import com.crs.lt.beans.Student;
import java.util.ArrayList;

/**
 * @author user214
 *
 */
public class StudentService implements StudentServiceInterface{
	static int counter=0;


	private List <Student> list=new ArrayList<Student>();

	public void changePassword() {
		// TODO Auto-generated method stub
		
	}

	public void register() {
		// TODO Auto-generated method stub
	Student student=new Student();
	counter++;
	student.setName("AAA");
	student.setStudentId(counter+100);
	student.setBatch(counter);
	student.setBranch("Science");
	student.setRole("Student");
	student.setUserId(1000+counter);
	list.add(student);
	
	}

	public void viewCard() {
		// TODO Auto-generated method stub
		
	}

	public void registerCourse() {
		// TODO Auto-generated method stub
		
	}

	public void addCourse() {
		// TODO Auto-generated method stub
		
	}

	public void dropcourse() {
		// TODO Auto-generated method stub
		
	}

	public void dropCourse() {
		// TODO Auto-generated method stub
		
	}

	public void viewCourses() {
		// TODO Auto-generated method stub
		
	}

	public void viewRegisteredCourses() {
		// TODO Auto-generated method stub
		
	}

	public void viewGradeCard() {
		// TODO Auto-generated method stub
		
	}

	public void payment() {
		// TODO Auto-generated method stub
		
	}
	

}
