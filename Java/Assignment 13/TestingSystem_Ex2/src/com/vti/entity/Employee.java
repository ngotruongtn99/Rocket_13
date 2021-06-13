package com.vti.entity;

public class Employee extends Account{
	private ProSkill proSkill;
	public enum ProSkill {
		DEV, TEST, JAVA, SQL
	}
	public Employee(int id, String fullname, String email, String password, Position position, Project project,
			ProSkill proSkill) {
		super(id, fullname, email, password, position, project);
		this.proSkill = proSkill;
	}
	public ProSkill getProSkill() {
		return proSkill;
	}
	public void setProSkill(ProSkill proSkill) {
		this.proSkill = proSkill;
	}
	
	
}
