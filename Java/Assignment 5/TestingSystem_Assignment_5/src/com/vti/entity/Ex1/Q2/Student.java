package com.vti.entity.Ex1.Q2;

public class Student {
	private int id;
	private String name;
	private String address;
	private int priority;
	private KhoiThi khoiThi;
	
	public int getId() {
		return id;
	}
	
	private static int CODE = 0;
	public Student(String name, String address, int priority, KhoiThi khoiThi) {
		CODE++;
		this.id = CODE;
		this.name = name;
		this.address = address;
		this.priority = priority;
		this.khoiThi = khoiThi;
	}
	@Override
	public String toString() {
		return "Student \nID:" + CODE +"\nHọ tên: " + name + "\nĐịa chỉ: " + address + "\nMức ưu tiên: " + priority + "\nKhối Thi: " + khoiThi.getName() +"\nMôn thi: " + khoiThi.getSubject();
	}
	
	
}
