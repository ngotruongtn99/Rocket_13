package com.vti.entity;

import java.time.LocalDate;

public class Account {
	private int id;
	private String email;
	private String username;
	private String fullname;
	private LocalDate createDate;
	public Account() {

	}



	@Override
	public String toString() {
		return "\nEmail: " + email + "\nUsername: " + username + "\nFullname: " + fullname + "\nCreateDate: "
				+ createDate;
	}



	public Account(String email, String username, String fullname, LocalDate createDate) {
		super();
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.createDate = createDate;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}