package com.vti.entity.Ex5.Q4;

import java.time.LocalDate;

public class Newspapers extends Library {
	private LocalDate dayRelease;

	public Newspapers(int codeID, String publishingCompany, int numberOfReleaseEdition, LocalDate dayRelease) {
		super(codeID, publishingCompany, numberOfReleaseEdition);
		this.dayRelease = dayRelease;
	}

	public LocalDate getDayRelease() {
		return dayRelease;
	}

	public void setDayRelease(LocalDate dayRelease) {
		this.dayRelease = dayRelease;
	}

	@Override
	public String toString() {
		return "Newspapers" + super.toString() + "\nDay Release: " + dayRelease + "]";
	}
	
	
}
