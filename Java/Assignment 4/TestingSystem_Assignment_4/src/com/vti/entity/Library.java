package com.vti.entity;

public class Library {
	private String codeId;
	private String publishingCompany;
	private int numberOfReleaseEdition ;
	
	public Library(String codeId, String publishingCompany, int numberOfReleaseEdition) {
		super();
		this.codeId = codeId;
		this.publishingCompany = publishingCompany;
		this.numberOfReleaseEdition = numberOfReleaseEdition;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public int getnumberOfReleaseEdition() {
		return numberOfReleaseEdition;
	}

	public void setnumberOfReleaseEdition(int numberOfReleaseEdition) {
		this.numberOfReleaseEdition = numberOfReleaseEdition;
	}

	@Override
	public String toString() {
		return "\nCodeId: " + codeId + "\nPublishing Company: " + publishingCompany + "\nNumber Of Release Edition: "
				+ numberOfReleaseEdition;
	}
	
	
}
