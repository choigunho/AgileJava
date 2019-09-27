package sis.report;

import java.util.ArrayList;
import java.util.Collections;

import sis.studentinfo.CourseSession;
import sis.studentinfo.Session;
import static sis.report.ReporterConstant.NEWLINE;

public class CourseReport {
	private ArrayList<Session> sessions = new ArrayList<Session>();
	
	public void add(Session session) {
		sessions.add(session);
	}
	
	public String text() {
		Collections.sort(sessions);
		StringBuilder builder = new StringBuilder();
		for(Session session : sessions)
			builder.append(
				session.getDepartment() + " " +
				session.getNumber() + NEWLINE);
		return builder.toString();
	}
}

// course report
// aaa