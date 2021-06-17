package com.vti.entity;

public class Employee extends Account {
	private ProSkill proSkill;
	
	public enum ProSkill {
		DEV, TEST, JAVA, SQL
	}
}
