/**
 * 
 */
package com.crs.lt.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.crs.lt.beans.Course;
import com.crs.lt.beans.GradeCard;
import com.crs.lt.beans.RegisteredCourse;
import com.crs.lt.beans.SemesterRegistration;
import com.crs.lt.beans.Student;

import com.crs.lt.dao.StudentDAOOperation;

/**
 * @author user214
 * 
 */
public class StudentService implements StudentServiceInterface {
	static int counter = 0;

	private List<Student> studentList = new ArrayList<Student>();
	//private List<SemesterRegistration> semList = new ArrayList<SemesterRegistration>();
	private List<GradeCard> gradeCardList=new ArrayList<GradeCard>();
	private List<RegisteredCourse> registeredCourseList=new ArrayList<RegisteredCourse>();
	private List<Course> courseList=new ArrayList<Course>();
	private Scanner sc=new Scanner(System.in);



	public void register() {
	
		Student student=new Student();
		
		System.out.println("Enter the email id :- ");
	
		
		
		/*student id will be auto increment */ 
		student.setEmailid(sc.next());
	
		System.out.println("Enter a password :- ");
		student.setPassword(sc.next());
		System.out.println("Enter student name :- ");
		student.setName(sc.next());
		student.setRole(1); /*default role for student */
		System.out.println("Enter the branch (EE/CS/EEE/MECH/CYBERSEC) :- ");
		student.setBranch(sc.next());
		System.out.println("Enter the semester/batch number :- ");
		student.setBatch(sc.nextInt());
		student.setApproved(false); /*need admins approvals */
		System.out.println(new StudentDAOOperation().registerStudent(student));
		
	
		

		
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
