package com.vti.backend;

import java.util.Date;

import com.vti.entity.Student;

public class Exercise2 {
	
	public void Question1() {
		
		@SuppressWarnings("deprecation")
		Date date = new Date(2020-1900, 5-1, 18);
		System.out.println(date);
	}
	
	@SuppressWarnings("deprecation")
	public void Question2() {
			Student st1 = new Student( "Nguyễn Văn A");
			System.out.println("Sinh viên 1: " + st1.getId() + " Họ tên: " + st1.getName());
			
			Student st2 = new Student( "Nguyễn Văn B");
			System.out.println("Sinh viên 2: " + st2.getIdWithMSV() + " Họ tên: " + st2.getName());
		
	}
}
