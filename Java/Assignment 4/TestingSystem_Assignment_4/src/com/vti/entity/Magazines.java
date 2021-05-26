package com.vti.entity;




public class Magazines extends Library {
	private int numberRelease;
	private int monthRelease;
	
	
	public Magazines(String codeId, String publishingCompany, int numberOfReleaseEdition, int numberRelease,
			int monthRelease) {
		super(codeId, publishingCompany, numberOfReleaseEdition);
		this.numberRelease = numberRelease;
		this.monthRelease = monthRelease;
	}

	public int getNumberRelease() {
		return numberRelease;
	}

	public void setNumberRelease(int numberRelease) {
		this.numberRelease = numberRelease;
	}

	public int getMonthRelease() {
		return monthRelease;
	}

	public void setMonthRelease(int monthRelease) {
		this.monthRelease = monthRelease;
	}

	@Override
	public String toString() {
		return "Magazines" + super.toString() + "\nNumber Release: " + numberRelease + "\nMonth Release: " + monthRelease;
	}
	
}
