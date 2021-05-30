package com.vti.entity.Ex2.Q1;

public class Student implements IStudent {
	@Override
	public String toString() {
		return "Student_Q1 [id=" + id + ", name=" + name + ", group=" + group + "]";
	}
	private int id;
	private String name;
	private int group;
	
	public static int COUNT = 0;
	public Student(String name, int group) {
		super();
		COUNT++;
		this.id = COUNT;
		this.name = name;
		this.group = group;
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

	public void setGroup(int group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public int getGroup() {
		return group;
	}

	@Override
	public void diemDanh() {
		System.out.println(this.name + " điểm danh");
	}
	@Override
	public void hocBai() {
		System.out.println(this.name + " đang học bài");
	}
	@Override
	public void diDonVeSinh() {
		System.out.println(this.name + " đang đi học vệ sinh" );
	}
	
}
