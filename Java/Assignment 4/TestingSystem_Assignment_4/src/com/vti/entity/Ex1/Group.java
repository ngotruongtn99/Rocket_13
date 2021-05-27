package com.vti.entity.Ex1;

import java.time.LocalDate;

public class Group {
	private int id;
	private String name;
	private Account creator;
	private LocalDate createDate;
	private Account[] accounts;
	
	public Group() {
		super();
	}

	public Group(String name, Account creator, LocalDate createDate, Account[] accounts) {
		super();
		this.name = name;
		this.creator = creator;
		this.createDate = createDate;
		this.accounts = accounts;
	}
	
	
}
