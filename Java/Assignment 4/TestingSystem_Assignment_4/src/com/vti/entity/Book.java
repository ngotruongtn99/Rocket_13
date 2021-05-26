package com.vti.entity;

public class Book extends Library {
	private String theWriterName;
	private int theNumberOfPage;
	
	public Book(String codeId, String publishingCompany, int releaseNumber, String theWriterName, int theNumberOfPage) {
		super(codeId, publishingCompany, releaseNumber);
		this.theWriterName = theWriterName;
		this.theNumberOfPage = theNumberOfPage;
	}
	
	public String getTheWriterName() {
		return theWriterName;
	}
	public void setTheWriterName(String theWriterName) {
		this.theWriterName = theWriterName;
	}
	public int getTheNumberOfPage() {
		return theNumberOfPage;
	}
	public void setTheNumberOfPage(int theNumberOfPage) {
		this.theNumberOfPage = theNumberOfPage;
	}
	@Override
	public String toString() {
		return "Book" + super.toString() +  "The Writer's Name: " + theWriterName + "\nThe Number Of Page: " + theNumberOfPage;
	}
	
}
