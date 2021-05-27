package com.vti.entity.Ex1;

import java.time.LocalDate;

public class Account {
	private int id;
	private String email;
	private String username;
	private String fullname;
	private Position position;
	private LocalDate createDate;
	public Account() {
		super();
	}

	public Account(int id, String email, String username, String FirstName, String LastName) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = FirstName + LastName;
	}

	public Account(int id, String email, String username, String FirstName, String LastName, Position position) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = FirstName + LastName;
		this.position = position;
		this.createDate = LocalDate.now();
	}

	public Account(int id, String email, String username, String FirstName, String LastName, Position position, LocalDate createDate) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = FirstName + LastName;
		this.position = position;
		this.createDate = createDate;
	}
	
	
	
}
