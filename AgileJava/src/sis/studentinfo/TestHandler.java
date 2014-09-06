package sis.studentinfo;

import java.util.logging.*;

public class TestHandler extends Handler {
	private LogRecord record;

	public void flush() {
	}

	public void close() throws SecurityException {
	}

	public void publish(LogRecord record) {
		this.record = record;
	}
	
	String getMessage() {
		return record.getMessage();
	}

}
