package com.vti.entity.Ex5.Q1_2;

public abstract class Staff {
	private String name;
	private int age;
	private Gender gioiTinh;
	private String address;
	
	
	public Staff(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	@Override
	public String toString() {
		return "\nName: " + name + "\nAge: " + age + "\nGender: " + gioiTinh + "\nAddress: " + address;
	}
	public Gender getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh (int gioiTinh) {
		if(gioiTinh == 0) {
			this.gioiTinh = Gender.valueOf("MALE");
		}else if (gioiTinh == 1) {
			this.gioiTinh = Gender.valueOf("FEMALE");
		} else {
			this.gioiTinh = Gender.valueOf("UNKNOWN");
		}

	}
	
	public Staff() {
		super();
	}
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	};
	
}
