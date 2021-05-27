package com.vti.entity.Ex6.Q2;

public class Waiter extends User {

	public Waiter(String name, Double salaryRatio) {
		super(name, salaryRatio);
	}

	@Override
	public Double calculatePay() {
		return salaryRatio * 220;
	}
	
}
