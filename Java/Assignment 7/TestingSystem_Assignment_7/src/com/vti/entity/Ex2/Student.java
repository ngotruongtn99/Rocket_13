package com.vti.entity.Ex2;

import com.vti.ultis.ScannerUltis;

public class Student {
	private final int id = 1;
	private String name;
	
	public Student() {
		super();
		
	}

	@Override
	public String toString() {
		return "Student Id: " + id + "\nName: " + getName();
	}
	
	public final void study() {
		System.out.println(getName() + " đang học bài");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}	
