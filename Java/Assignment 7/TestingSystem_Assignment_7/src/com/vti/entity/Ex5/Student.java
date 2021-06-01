package com.vti.entity.Ex5;


public class Student {
	private int id;
	private String name;
	public static int COUNT = 0;
	
	public Student(String name) {
		super();
		COUNT++;
		this.id = COUNT;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student " + COUNT + "\nId: " + id + "\nName: " + name +"\n";
	}
	
	
}
