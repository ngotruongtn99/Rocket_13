package com.vti.entity.Ex6;

public class Contact {
	private String phone;
	private String name;

	public Contact(String phone, String name) {
		super();
		this.phone = phone;
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Contact: \nPhone: " + phone + "\nName: " + name;
	}

}
