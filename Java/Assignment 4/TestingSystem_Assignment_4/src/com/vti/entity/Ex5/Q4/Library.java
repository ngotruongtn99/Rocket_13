package com.vti.entity.Ex5.Q4;

public abstract class Library {
	private int codeID;
	private String publishingCompany;
	private int numberOfReleaseEdition ;
	
	public Library(int codeId, String publishingCompany, int numberOfReleaseEdition) {
		super();
		this.codeID = codeId;
		this.publishingCompany = publishingCompany;
		this.numberOfReleaseEdition = numberOfReleaseEdition;
	}

	public int getCodeId() {
		return codeID;
	}

	public void setCodeId(int codeId) {
		this.codeID = codeId;
	}


	public String getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public int getNumberOfReleaseEdition() {
		return numberOfReleaseEdition;
	}

	public void setNumberOfReleaseEdition(int numberOfReleaseEdition) {
		this.numberOfReleaseEdition = numberOfReleaseEdition;
	}

	@Override
	public String toString() {
		return "\nCodeId: " + codeID + "\nPublishing Company: " + publishingCompany + "\nNumber Of Release Edition: "
				+ numberOfReleaseEdition;
	}
	
	
}
