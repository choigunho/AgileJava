package sis.report;

import sis.studentinfo.*;
import junit.framework.TestCase;
//import java.util.*;
import static sis.report.ReporterConstant.NEWLINE;

public class RosterReporterTest extends TestCase {
	public void testRosterReport() {
//		CourseSession session = CourseSession.create("ENGL", "101", DateUtil.createDate(2003, 1, 6));
		Session session = CourseSession.create(new Course("ENGL", "101"), DateUtil.createDate(2003, 1, 6));
		
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
		
		String rosterReport = new RosterReporter(session).getReport();
		System.out.println(rosterReport);
		assertEquals(
				RosterReporter.ROSTER_REPORT_HEADER +
				"A" + NEWLINE +
				"B" + NEWLINE +
				RosterReporter.ROSTER_REPORT_FOOTER + "2" +
				NEWLINE, rosterReport);
	}
}
