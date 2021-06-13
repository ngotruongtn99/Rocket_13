package com.vti.entity;

public class Account {
	private int id;
	private String fullname;
	private String email;
	private String password;
	private Position position;
	private Project project;
	public enum Position {
		MANAGER, EMPLOYEE
	}
	public Account(int id, String fullname, String email, String password, Position position, Project project) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.position = position;
		this.project = project;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPosition() {
		return position.name();
	}
	public String setPosition(String position) {
		return position;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

	
}
