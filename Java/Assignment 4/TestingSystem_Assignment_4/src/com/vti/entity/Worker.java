package com.vti.entity;

public class Worker extends Staff {
	private int rank;

	public Worker(String name, int age, String address, int rank) {
		super(name, age, address);
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Worker: "+ super.toString() +  "\nRank: " + rank;
	}
}
