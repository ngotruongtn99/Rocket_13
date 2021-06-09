package com.vti.entity;

public class Student {
	public static int COUNT = 0;
	private int id;
	private String name;
	
	public Student(String name) {
		super();
		COUNT++;
		this.id = COUNT;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student id: " + id + ", Name: " + name ;
	}
	
}
