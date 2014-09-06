package sis.studentinfo;

import java.util.logging.Handler;
import java.util.logging.Logger;

public class StudentTest extends junit.framework.TestCase {
	private static final double GRADE_TOLERANCE = 0.05;
	
	public void testCreate() {
		final String firstStudentName = "Jane Doe";
		Student firstStudent = new Student(firstStudentName);
		assertEquals("Jane", firstStudent.getFirstName());
		assertEquals("Doe", firstStudent.getLastName());
		assertEquals("", firstStudent.getMiddleName());
		
		final String secondStudentName = "Blow";
		Student secondStudent = new Student(secondStudentName);
		assertEquals("", secondStudent.getFirstName());
		assertEquals("Blow", secondStudent.getLastName());
		assertEquals("", secondStudent.getMiddleName());
		
		final String thirdStudentName = "Raymond Doutglas Davies";
		Student thirdStudent = new Student(thirdStudentName);
		assertEquals("Raymond", thirdStudent.getFirstName());
		assertEquals("Davies", thirdStudent.getLastName());
		assertEquals("Doutglas", thirdStudent.getMiddleName());
	}
		
	public void testStudentStatus() {
		Student student = new Student("a");
		assertEquals(0, student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(3);
		assertEquals(3, student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(4);
		assertEquals(7, student.getCredits());
		assertFalse(student.isFullTime());
//		assertTrue("not enough credits for FT status", student.isFullTime());
		
		student.addCredits(5);
		assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
		assertTrue(student.isFullTime());
	}
	
	public void testInState() {
		Student student = new Student("a");
		assertFalse(student.isInState());
		student.setState(Student.IN_STATE);
		assertTrue(student.isInState());
		student.setState("MD");
		assertFalse(student.isInState());
	}
	
	public void testCalculateGpa() {
		Student student = new Student("a");
		assertGpa(student, 0.0);
		student.addGrade(Student.Grade.A);
		assertGpa(student, 4.0);
		student.addGrade(Student.Grade.B);
		assertGpa(student, 3.5);
		student.addGrade(Student.Grade.C);
		assertGpa(student, 3.0);
		student.addGrade(Student.Grade.D);
		assertGpa(student, 2.5);
		student.addGrade(Student.Grade.F);
		assertGpa(student, 2.0);
	}
	
	public void testCalculateHonorsStudentGpa() {
		assertGpa(createHonorsStudent(), 0.0);
		assertGpa(createHonorsStudent(Student.Grade.A), 5.0);
		assertGpa(createHonorsStudent(Student.Grade.B), 4.0);
		assertGpa(createHonorsStudent(Student.Grade.C), 3.0);
		assertGpa(createHonorsStudent(Student.Grade.D), 2.0);
		assertGpa(createHonorsStudent(Student.Grade.F), 0.0);
	}
	
	private Student createHonorsStudent(Student.Grade grade) {
		Student student = createHonorsStudent();
		student.addGrade(grade);
		return student;
	}
	
	private Student createHonorsStudent() {
		Student student = new Student("a");
//		student.setHonors();
		student.setGradingStrategy(new HonorsGradingStrategy());
		return student;
	}
	
	private void assertGpa(Student student, double expectedGpa) {
		assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
	}
	
	public void testBadlyFormattedName() {
//		Logger logger = Logger.getLogger(Student.class.getName());
		Handler handler = new TestHandler();
		Student.logger.addHandler(handler);
		
		final String studentName = "a b c d";
		try {
			new Student(studentName);
			fail("expected exception from 4-part name");
		}
		catch (StudentNameFormatException expectedException) {
			String message = 
					String.format(Student.TOO_MANY_NAME_PARTS_MSG,
							studentName, Student.MAX_NAME_PARTS);
			assertEquals(message, expectedException.getMessage());
			assertEquals(message, ((TestHandler)handler).getMessage());
		}
	}
	
	private boolean wasLogged(String message, TestHandler handler) {
		return message.equals(handler.getMessage());
	}
}