package com.vti.entity;

public class Manager extends Account{
	private int expInYear;

	public Manager(int id,String fullname, String email, String password, Position position, Project project, int expInYear) {
		super(id, fullname, email, password, position, project);
		this.expInYear = expInYear;
	}

	public Manager() {
		
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}


	
}
