package com.vti.entity;

public class Student {
	private int id;
	private String name;
	public static int  COUNT = 0;
	
	
	public Student(String name) {
		super();
		COUNT++;
		this.id = COUNT;
		this.name = name;
	}
	/**
	*
	*@deprecated replace by {@link #getIdWithMSV()}
	*/
	@Deprecated
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
	public String getIdWithMSV() {
		return "MSV "+ id;
	}
}
