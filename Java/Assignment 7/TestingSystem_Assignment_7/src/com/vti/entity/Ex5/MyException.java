package com.vti.entity.Ex5;

import java.time.DateTimeException;

public class MyException extends Exception {
	private String message;
	private String reason;
	private String stackTrace;
	private DateTimeException time;
	
	
	@Override
	public String toString() {
		return "MyException \nMessage: " + message + "\nReason: " + reason + "\nStackTrace: " + stackTrace + "\nTime: "
				+ time;
	}
	
	
}
