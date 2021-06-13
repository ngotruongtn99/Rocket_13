package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.businesslayer.CandidateService;
import com.vti.backend.businesslayer.ICandidateService;
import com.vti.entity.ExperienceCandidate.ProSkill;
import com.vti.entity.FresherCandidate.GraduationRank;

public class CandidateController {

	private ICandidateService candidateController;
	
	public CandidateController() throws FileNotFoundException, IOException {
		candidateController = new CandidateService();
	}

	public boolean isEmailexists(String email) throws ClassNotFoundException, SQLException {
		return candidateController.isEmailexists(email);
	}

	
	public boolean createExperienceCandidate(String firstName, String lastName, String phone, String email,
			String passWord, int ExpInYear, ProSkill proSkill) throws ClassNotFoundException, SQLException {
		return candidateController.createExperienceCandidate(firstName, lastName, phone, email, passWord, ExpInYear, proSkill);
	}


	public boolean createFresherCandidate(String firstName, String lastName, String phone, String email,
			String passWord, GraduationRank graduationRank) throws ClassNotFoundException, SQLException {
		return candidateController.createFresherCandidate(firstName, lastName, phone, email, passWord, graduationRank);
	}


	public boolean loginCandidate(String email, String passWord) throws ClassNotFoundException, SQLException {
		return candidateController.loginCandidate(email, passWord);
	}

}
