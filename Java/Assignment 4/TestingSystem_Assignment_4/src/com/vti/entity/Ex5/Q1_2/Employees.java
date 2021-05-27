package com.vti.entity.Ex5.Q1_2;

public class Employees extends Staff {
	private String tasks;

	public Employees(String name, int age, String address, String tasks) {
		super(name, age, address);
		this.tasks = tasks;
	}

	public String getTasks() {
		return tasks;
	}

	public void setTasks(String tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Employees: "+ super.toString() + "\nTasks: " + tasks;
	}
	
}	
