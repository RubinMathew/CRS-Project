/**
 * 
 */
package com.crs.lt.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.crs.lt.beans.Course;
import com.crs.lt.beans.GradeCard;
import com.crs.lt.beans.RegisteredCourse;
import com.crs.lt.beans.SemesterRegistration;
import com.crs.lt.beans.Student;

/**
 * @author user214
 * 
 */
public class StudentService implements StudentServiceInterface {
	static int counter = 0;

	private List<Student> studentList = new ArrayList<Student>();
	private List<SemesterRegistration> semList = new ArrayList<SemesterRegistration>();
	private List<GradeCard> gradeCardList=new ArrayList<GradeCard>();
	private List<RegisteredCourse> registeredCourseList=new ArrayList<RegisteredCourse>();
	private List<Course> courseList=new ArrayList<Course>();



	public void register() {
		// TODO Auto-generated method stub
		Student student = new Student();
		
		student.setName("AAA");
		student.setStudentId(counter + 100);
		counter++;
		student.setBatch(counter);
		student.setBranch("Science");
		student.setRole("Student");
		student.setUserId(1000 + counter);
		student.setPassword("password");
		studentList.add(student);

	}

	public void viewCard() {
		// TODO Auto-generated method stub

	}

	public boolean changePassword(int studentId, String currentPassword,String newPassword) {
		for (Student s : studentList) {
			if (s.getStudentId() == studentId) {
				if (s.getPassword().equals(currentPassword)) {
					s.setPassword(newPassword);
					return true;

				}
			}
		}

		return false;

	}

	public void registerCourse(int studentId) {
		// TODO Auto-generated method stub
		// code for semester registration
		SemesterRegistration sr = new SemesterRegistration();
		sr.setStudentId(studentId);
		sr.setDateofRegistration(new Date());
	    sr.setSemester(1); // all students  will be enrolled on semester 1 by default

	}

	public void addCourse(String courseCode,int studentID) {
		// TODO Auto-generated method stub
		RegisteredCourse registeredcourse=new RegisteredCourse();
		registeredcourse.setCourseCode("course1");
		registeredcourse.setSemester(1);
		registeredcourse.setStudentId(studentID);
		registeredCourseList.add(registeredcourse);
		

	}

	public void dropcourse(int studentid,String courseCode,int semesterID) {
		
		for(RegisteredCourse re:registeredCourseList)
			
		{
			if(re.getStudentId()==studentid&&re.getCourseCode().equals("course1")&&re.getSemester()==semesterID){
				registeredCourseList.remove(re); 
			}
		}
		// TODO Auto-generated method stub

	}

	public void dropCourse() {
		// TODO Auto-generated method stub

	}

	public void viewCourses() {
		for(Course co:courseList){
			System.out.println("Course Code : "+co.getCourseCode());
			System.out.println("Course Name : "+co.getCourseName());
			System.out.println("Instrucotr Name : "+co.getInstructor());
			System.out.println("-------------------------------------------------");
		}
		// TODO Auto-generated method stub

	}

	public void viewRegisteredCourses(int studentId) {
		Student st=null;
		for(Student s:studentList){
			if(s.getStudentId()==studentId){
				st=s;
				
			}
		}
		
		for(RegisteredCourse rc:registeredCourseList){
			if(rc.getStudentId()==studentId){
				System.out.println("Student id :"+rc.getStudentId());
				System.out.println("Student Name : "+st.getName());
				System.out.println("Course Code : "+rc.getCourseCode());
				System.out.println("Semester"+rc.getSemester());
				System.out.println("Grade"+rc.getGrade());
			
		
			}
		}
		
		
		// TODO Auto-generated method stub

	}

	public void viewGradeCard(int studentId, int semesterId) {

		// TODO Auto-generated method stub
		Student st=null;
		for(Student s:studentList){
			if(s.getStudentId()==studentId){
				st=s;
				
			}
		}
		for(GradeCard gc:gradeCardList){
			if(gc.getStudentId()==studentId&&gc.getSemester()==semesterId)
			{
			
				System.out.println("StudentId :"+gc.getStudentId());
				System.out.println("Student Name: "+st.getName());
				System.out.println("Semester :"+gc.getSemester());
				System.out.println("CPI : "+gc.getCpi());
				//System.out.println("Registered Course "+gc.getRegisteredCourses());
				
			}
		}

	}

	public void payment() {
		// TODO Auto-generated method stub
		// do payment activities here
		

	}


}
