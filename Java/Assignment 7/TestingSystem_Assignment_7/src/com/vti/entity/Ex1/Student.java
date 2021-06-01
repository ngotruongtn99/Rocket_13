package com.vti.entity.Ex1;

import com.vti.ultis.ScannerUltis;

public class Student {
	private int id;
	private String name;
	public static String college = "Đại học bách khoa";
	private static int COUNT = 0;
	public static int moneyGroup = 0;
	
	public Student() {
		super();
		this.id = ++COUNT;
		System.out.println("Nhập vào tên Sinh viên");
		this.name = ScannerUltis.inputString();
	}

	@Override
	public String toString() {
		return "Student id: " + id + "\nName: " + name +  "\nCollege: " + college;
	}
	public static void changeCollege() {
		System.out.println("Nhập vào tên College muốn thay đổi");
		Student.college = ScannerUltis.inputString();
	}
	public static void showCollege() {
		System.out.println("College: " + college);
	}
}
