package sis.studentinfo;

import java.util.*;
import java.util.logging.*;

public class Student {
	public enum Grade {
		A(4), 
		B(3), 
		C(2), 
		D(1), 
		F(0);
		
		private int points;
		
		Grade(int points) {
			this.points = points;
		}
		
		int getPoints() {
			return points;
		}
	}
	
	private List<Grade> grades = new ArrayList<Grade>();
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "CO";
	static final String TOO_MANY_NAME_PARTS_MSG = "Student name '%s' contains more than %d parts";
	static final int MAX_NAME_PARTS = 3;
	private String name;
	private int credits;
	private String state = "";
	private String firstName = "";
	private String middleName = "";
	private String lastName;
	private boolean isHonors = false;
	private GradingStrategy gradingStrategy = new BasicGradingStrategy();
	final static Logger logger = Logger.getLogger(Student.class.getName());
	
	public Student(String fullName) {
		this.name = fullName;
		credits = 0;
		List<String> nameParts = split(fullName);
		final int maximumNumberOfNameParts = 3;
		
		
		if(nameParts.size() > maximumNumberOfNameParts) {
			String message =
					String.format(Student.TOO_MANY_NAME_PARTS_MSG,
							fullName, MAX_NAME_PARTS);
			// 여기에 메시지를 로그에 기록한다.
//			log(message);
			Student.logger.info(message);
			throw new StudentNameFormatException(message);
		}
		setName(nameParts);
	}
	
	private void log(String message) {
		Logger logger = Logger.getLogger(getClass().getName());
		logger.info(message);
	}
	
	private void setName(List<String> nameParts) {
		this.lastName = removeLast(nameParts);
		String name = removeLast(nameParts);
		if(nameParts.isEmpty())
			this.firstName = name;
		else {
			this.middleName = name;
			this.firstName = removeLast(nameParts);
		}
	}
	
//	private List<String> split(String name) {
//		List<String> results = new ArrayList<String>();
//		
//		StringBuffer word = new StringBuffer();
//		for(int index = 0; index < name.length(); index++) {
//			char ch = name.charAt(index);
//			if(!Character.isWhitespace(ch))
//				word.append(ch);
//			else
//				if(word.length() > 0) {
//					results.add(word.toString());
//					word = new StringBuffer();
//				}
//		}
//		if(word.length() > 0)
//			results.add(word.toString());
//		return results;
//	}
	
	private List<String> split(String fullName) {
		List<String> results = new ArrayList<String>();
		for(String name: fullName.split(" "))
			results.add(name);
		return results;
	}
	
	private String removeLast(List<String> list) {
		if(list.isEmpty())
			return "";
		return list.remove(list.size() - 1);
	}
	
	public String getName() {
		return name;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	boolean isFullTime() {
//		return false;
		return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
	}
	
	int getCredits() {
		return credits;
	}
	
	void addCredits(int credits) {
		this.credits += credits;
	}
	
	void setState(String state) {
		this.state = state;
	}
	
	void addGrade(Grade grade) {
		grades.add(grade);
	}
	
	boolean isInState() {
		return state.equals(Student.IN_STATE);
	}
	
	double getGpa() {
		if (grades.isEmpty())
			return 0;
		double total = 0.0;
		for(Grade grade : grades)
			total += gradingStrategy.getGradePointsFor(grade);
		return total / grades.size();
	}
	
	void setHonors() {
		isHonors = true;
	}
	
	int gradePointsFor(Grade grade) {
		return gradingStrategy.getGradePointsFor(grade);
	}
		
	void setGradingStrategy(GradingStrategy gradingStrategy) {
		this.gradingStrategy = gradingStrategy;
	}
}
