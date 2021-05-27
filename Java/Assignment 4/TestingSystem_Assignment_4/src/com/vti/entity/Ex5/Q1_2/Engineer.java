package com.vti.entity.Ex5.Q1_2;

public class Engineer extends Staff {
	private String specialized;

	public Engineer(String name, int age, String address, String specialized) {
		super(name, age, address);
		this.specialized = specialized;
	}

	public String getSpecialized() {
		return specialized;
	}

	public void setSpecialized(String specialized) {
		this.specialized = specialized;
	}

	@Override
	public String toString() {
		return "Engineer: "+ super.toString() + "\nSpecialized: " + specialized ;
	}
	
	
}
