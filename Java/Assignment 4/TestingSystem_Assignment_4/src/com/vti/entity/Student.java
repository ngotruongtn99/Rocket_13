package com.vti.entity;


public class Student {
	private int id;
	private String name;
	private	String homeTown;
	private int mark;
	
	
	public Student(int id, String name, String homeTown, int mark) {
		super();
		this.id = id;
		this.name = name;
		this.homeTown = homeTown;
		this.mark = mark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "Id = " + id + ", Name: " + name + ", HomeTown: " + homeTown + ", Mark = " + mark;
	}
	
}
