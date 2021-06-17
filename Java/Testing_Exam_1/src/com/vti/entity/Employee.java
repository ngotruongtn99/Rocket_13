package com.vti.entity;

public class Employee extends User {

	private ProSkill proSkill;

	public enum ProSkill {
		DEV, TEST, JAVA, SQL
	}
}
