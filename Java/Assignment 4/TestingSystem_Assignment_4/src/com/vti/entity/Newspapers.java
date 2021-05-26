package com.vti.entity;

public class Newspapers extends Library {
	private int dayRelease;

	public Newspapers(String codeId, String publishingCompany, int numberOfReleaseEdition, int dayRelease) {
		super(codeId, publishingCompany, numberOfReleaseEdition);
		this.dayRelease = dayRelease;
	}

	public int getDayRelease() {
		return dayRelease;
	}

	public void setDayRelease(int dayRelease) {
		this.dayRelease = dayRelease;
	}

	@Override
	public String toString() {
		return "Newspapers" + super.toString() + "\nDay Release: " + dayRelease + "]";
	}
	
	
}
