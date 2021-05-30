package com.vti.entity.Ex2;

public class Department {
	public static int COUNT = 0;
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public Department(String name) {
		COUNT++;
		this.id = COUNT;
		this.name = name;
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
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Department \nId: " + id + "\nName: " + name;
	}
	
	
}
