package com.vti.entity;

public class ProjectAndUser {
	private Project project;
	private Account account;
	private Role role;

	public enum Role {	
		MANAGER, EMPLOYEE
	}
}
