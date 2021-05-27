package com.vti.entity.Ex6.Q2;

public class Employee extends User {

	public Employee(String name, Double salaryRatio) {
		super(name, salaryRatio);
	}

	@Override
	public Double calculatePay() {
		return salaryRatio * 420;
	}

	@Override
	public void displayInfor() {
		super.displayInfor();
	}

}
