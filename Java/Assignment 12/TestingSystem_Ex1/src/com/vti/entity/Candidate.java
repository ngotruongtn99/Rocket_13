package com.vti.entity;

public abstract class Candidate {
	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String password;
	private Category category;
	public enum Category {
		EXPERIENCECANDIDATE, FRESHERCANDIDATE
	}
	public Candidate(String firstName, String lastName, String phone, String email, String password,
			Category category) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.category = category;
	}

	
}
