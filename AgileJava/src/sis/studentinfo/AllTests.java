package sis.studentinfo;

import junit.framework.TestSuite;

public class AllTests {
	public static junit.framework.TestSuite suite() {
		TestSuite suite = new junit.framework.TestSuite();
		suite.addTestSuite(StudentTest.class);
		suite.addTestSuite(SessionTest.class);
		suite.addTestSuite(CourseSessionTest.class);
//		suite.addTestSuite(RosterReporterTest.class);
		suite.addTestSuite(DateUtilTest.class);
		suite.addTestSuite(BasicGradingStrategyTest.class);
		suite.addTestSuite(HonorsGradingStrategyTest.class);
		return suite;
	}
}
