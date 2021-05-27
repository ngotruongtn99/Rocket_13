package com.vti.entity.Ex4;


public class Student {
	private int id;
	private String name;
	private	String homeTown;
	private Float mark;
	
	
	public Student(int id, String name, String homeTown) {
		super();
		this.id = id;
		this.name = name;
		this.homeTown = homeTown;
		this.mark = (float) 0;
	}
	
	public void setMark(float mark) {
		this.mark = mark;
	}
	
	public void plusMark(Float mark) {
		this.mark = this.mark + mark;
	}
	@Override
	public String toString() {
		String rank = null;
		if (this.mark < 4.0) {
			rank = "Yếu";
		} else if (this.mark < 6.0) {
			rank = "Trung bình";
		} else if (this.mark < 8.0) {
			rank = "Khá";
		}else {
			rank = "Giỏi";
		}
		return "Student: \nId: " + id + "\nName: " + name + "\nHomeTown: " + homeTown + "\nMark = " + mark + "\nRank:" + rank;
	}
	
}
