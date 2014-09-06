package sis.summer;

import java.util.*;
import sis.studentinfo.*;

public class SummerCourseSession extends Session {
//	public static SummerCourseSession create(String department, String number, Date startDate) {
//		return new SummerCourseSession(department, number, startDate);		
//	}
	public static Session create(Course course, Date startDate) {
		return new SummerCourseSession(course, startDate);
	}
	
	private SummerCourseSession(Course course, Date startDate) {
		super(course, startDate);
	}
	
	@Override
	protected int getSessionLength() {
		return 8;
	}
	
//	public Date getEndDate() {
//		GregorianCalendar calendar = new GregorianCalendar();
//		calendar.setTime(getStartDate());
//		int daysInWeek = 7;
//		int daysFromFridayToMonday = 3;
//		int numberOfDays = getSessionLength() * daysInWeek - daysFromFridayToMonday;
//		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
//		return calendar.getTime();
//	}
}
