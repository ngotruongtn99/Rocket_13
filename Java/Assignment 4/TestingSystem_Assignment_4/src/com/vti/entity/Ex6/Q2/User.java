package com.vti.entity.Ex6.Q2;

public abstract class User {
	private String name;
	Double salaryRatio;

	public User(String name, Double salaryRatio) {
		super();
		this.name = name;
		this.salaryRatio = salaryRatio;

	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalaryRatio() {
		return salaryRatio;
	}
	public void setSalaryRatio(Double salaryRatio) {
		this.salaryRatio = salaryRatio;
	}
	public abstract Double calculatePay();

	public void displayInfor() {
		System.out.println("Name: " + name);
		System.out.println("Ration Salary: " + salaryRatio);
		System.out.println("Lương chi trả: " + calculatePay());

		}

}