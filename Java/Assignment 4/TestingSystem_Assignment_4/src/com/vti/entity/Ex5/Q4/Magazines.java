package com.vti.entity.Ex5.Q4;

import java.time.LocalDate;

public class Magazines extends Library {
	private int numberRelease;
	private LocalDate monthRelease;
	
	
	public Magazines(int codeID, String publishingCompany, int numberOfReleaseEdition, int numberRelease,
			LocalDate monthRelease) {
		super(codeID, publishingCompany, numberOfReleaseEdition);
		this.numberRelease = numberRelease;
		this.monthRelease = monthRelease;
	}

	public int getNumberRelease() {
		return numberRelease;
	}

	public void setNumberRelease(int numberRelease) {
		this.numberRelease = numberRelease;
	}

	public LocalDate getMonthRelease() {
		return monthRelease;
	}

	public void setMonthRelease(LocalDate monthRelease) {
		this.monthRelease = monthRelease;
	}

	@Override
	public String toString() {
		return "Magazines" + super.toString() + "\nNumber Release: " + numberRelease + "\nMonth Release: " + monthRelease;
	}
	
}
