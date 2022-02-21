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
import com.crs.lt.dao.CourseDAOOperation;
import com.crs.lt.dao.StudentDAOOperation;
import crs.lt.exceptions.CourseNotFoundException;
import org.apache.log4j.Logger;
/**
 * @author user214
 * 
 */
public class StudentService implements StudentServiceInterface {
	private static Logger logger = Logger.getLogger(StudentService.class);
	static int counter = 0;

	private List<Student> studentList = new ArrayList<Student>();
	// private List<SemesterRegistration> semList = new
	// ArrayList<SemesterRegistration>();
	private List<GradeCard> gradeCardList = new ArrayList<GradeCard>();
	private List<RegisteredCourse> registeredCourseList = new ArrayList<RegisteredCourse>();
	private Scanner sc = new Scanner(System.in);
	public void register() {

		Student student = new Student();
		logger.info("Enter the email id :- \n");
		/* student id will be auto increment */
		student.setEmailid(sc.next());
		logger.info("Enter a password :- \n");
		student.setPassword(sc.next());
		logger.info("Enter student name :- \n");
		student.setName(sc.next());
		student.setRole(3); /* default role for student */
		logger.info("Enter the branch (EE/CS/EEE/MECH/CYBERSEC) :- \n");
		student.setBranch(sc.next());
		logger.info("Enter the semester/batch number :- \n");
		student.setBatch(sc.nextInt());
		student.setApproved(false); /* need admins approvals */
		logger.info(new StudentDAOOperation().registerStudent(student));
		sc.next();

	}

	public void viewCard() {
		// TODO Auto-generated method stub

	}

	public boolean changePassword(int studentId, String currentPassword,
			String newPassword) {
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
		sr.setSemester(1); // all students will be enrolled on semester 1 by
							// default

	}

	public boolean addCourse( int studentId) {
		// TODO Auto-generated method stub
		//RegisteredCourse registeredcourse = new RegisteredCourse();
		Scanner sc= new Scanner(System.in);
		logger.info("Enter the Course ID : - \n ");
		int courseId=sc.nextInt();
		return new StudentDAOOperation().registerCourse(studentId, courseId);

	}

	public void dropcourse(int studentid, String courseCode, int semesterID) {

		for (RegisteredCourse re : registeredCourseList)
		{
			if (re.getStudentId() == studentid
					&& re.getCourseCode().equals("course1")
					&& re.getSemester() == semesterID) {
				registeredCourseList.remove(re);
			}
		}
		// TODO Auto-generated method stub

	}

	public void dropCourse() {
		// TODO Auto-generated method stub

	}

	public void viewCourses()throws CourseNotFoundException {
		List<Course> courseList = new CourseDAOOperation()
				.getAvailableCourses();
		if (!courseList.isEmpty()) {
			for (Course co : courseList) {
				System.out
						.println("-------------------------------------------------");
				logger.info("Course Id : " + co.getCourseId());
				logger.info("Course Code : " + co.getCourseCode());
				logger.info("Course Name : " + co.getCourseName());
				logger.info("Instructr Id : " + co.getInstructor());
				System.out
						.println("Available Seats : " + co.getAvailbleSeats());
				logger.info("Offered : " + co.isOffered());
				System.out
						.println("-------------------------------------------------");
			}
			
		}
		else
		{
			throw new CourseNotFoundException("No Coursesa are offered !");
		}
		return;
		// TODO Auto-generated method stub

	}

	public void viewRegisteredCourses(int studentId) {
		Student st = null;
		for (Student s : studentList) {
			if (s.getStudentId() == studentId) {
				st = s;

			}
		}

		for (RegisteredCourse rc : registeredCourseList) {
			if (rc.getStudentId() == studentId) {
				logger.info("Student id :" + rc.getStudentId());
				logger.info("Student Name : " + st.getName());
				logger.info("Course Code : " + rc.getCourseCode());
				logger.info("Semester" + rc.getSemester());
				logger.info("Grade" + rc.getGrade());

			}
		}

		// TODO Auto-generated method stub

	}


	public void viewGradeCard(int studentId, int semesterId) {

		// TODO Auto-generated method stub
		Student st = null;
		for (Student s : studentList) {
			if (s.getStudentId() == studentId) {
				st = s;

			}
		}
		for (GradeCard gc : gradeCardList) {
			if (gc.getStudentId() == studentId && gc.getSemester() == semesterId) {

				logger.info("StudentId :" + gc.getStudentId());
				logger.info("Student Name: " + st.getName());
				logger.info("Semester :" + gc.getSemester());
				logger.info("CPI : " + gc.getCpi());
				// logger.info("Registered Course "+gc.getRegisteredCourses());

			}
		}

	}

	public void payment() {
		// TODO Auto-generated method stub
		// do payment activities here

	}

	@Override
	public int getStudentId(String emailId) {
	
	return new StudentDAOOperation().findStudentId(emailId.trim());
	}

}
