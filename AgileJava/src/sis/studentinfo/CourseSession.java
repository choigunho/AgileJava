package sis.studentinfo;

import java.util.*;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;

public class CourseSession extends Session {
//	static final String NEWLINE = System.getProperty("line.separator");
//	static final String ROSTER_REPORT_HEADER = 
//			"Student" + NEWLINE +
//			"-" + NEWLINE;
//	static final String ROSTER_REPORT_FOOTER = 
//			NEWLINE + "# students = ";
	private static int count;
	
//	private String department;
//	private String number;
//	private java.util.ArrayList<Student> students = new java.util.ArrayList<Student>();
//	protected Date startDate;
//	private int numberOfCredits;
//	private GradingStrategy gradingStrategy = new RegularGradingStrategy();
	
	public static CourseSession create(
			String department,
			String number,
			Date startDate) {
		return new CourseSession(department, number, startDate);
	}
	
	protected CourseSession(String department, String number, Date startDate) {
//		this.department = department;
//		this.number = number;
//		this.startDate = startDate;
		super(department, number, startDate);
		CourseSession.incrementCount();
	}
	
	static private void incrementCount() {
		++count;
	}

	static void resetCount() {
		count = 0;
	}
	
	static int getCount() {
		return count;
	}
	
	protected int getSessionLength() {
		return 16;
	}
//	public String getDepartment() {
//		return department;
//	}
	
//	public String getNumber() {
//		return number;
//	}
//	
//	int getNumberOfStudents() {
//		return students.size();
//	}
	
//	public void enroll(Student student) {
//		student.addCredits(numberOfCredits);
//		students.add(student);
//	}
//	
//	public ArrayList<Student> getAllStudents() {
//		return students;
//	}
//	
//	Student get(int index) {
//		return students.get(index);
//	}
//	
//	public Date getEndDate() {
//		GregorianCalendar calendar = new GregorianCalendar();
//		calendar.setTime(getStartDate());
//		final int daysInWeek = 7;
//		final int daysFromFridayToMonday = 3;
//		int numberOfDays = getSessionLength() * daysInWeek - daysFromFridayToMonday;
//		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
//		return calendar.getTime();
//	}
//	
//	protected Date getStartDate() {
//		return startDate;
//	}
//	
//	public static CourseSession create(
//			String department,
//			String number,
//			Date startDate) {
//		incrementCount();
//		return new CourseSession(department, number, startDate);
//	}
//	
//	void setNumberOfCredits(int numberOfCredits) {
//		this.numberOfCredits = numberOfCredits;
//	}
//
//	@Override
//	public int compareTo(CourseSession that) {
//		int compare = this.getDepartment().compareTo(that.getDepartment());
//		if(compare == 0) {
//			compare = this.getNumber().compareTo(that.getNumber());
//		}
//		return compare; 
//	}
//	
//	void setGradingStrategy(GradingStrategy gradingStrategy) {
//		this.gradingStrategy = gradingStrategy;
//	}
}
