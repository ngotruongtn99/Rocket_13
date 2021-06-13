package com.vti.entity;

public class FresherCandidate extends Candidate {
	private GraduationRank gruaduationRank;
	
	public GraduationRank getGruaduationRank() {
		return gruaduationRank;
	}

	public void setGruaduationRank(GraduationRank gruaduationRank) {
		this.gruaduationRank = gruaduationRank;
	}

	public enum GraduationRank {
		EXCELLENCE, GOOD, FAIR, POOR
	}

	public FresherCandidate(String firstName, String lastName, String phone, String email, String password,
			Category category, GraduationRank gruaduationRank) {
		super(firstName, lastName, phone, email, password, category);
		this.gruaduationRank = gruaduationRank;
	}

	
}
