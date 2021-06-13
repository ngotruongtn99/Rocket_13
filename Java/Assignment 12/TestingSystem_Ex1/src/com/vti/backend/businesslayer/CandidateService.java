package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.datalayer.CandidateRepository;
import com.vti.backend.datalayer.ICandidateRepository;
import com.vti.entity.ExperienceCandidate.ProSkill;
import com.vti.entity.FresherCandidate.GraduationRank;

public class CandidateService implements ICandidateService{
	private ICandidateRepository candidateRepository;
	
	public CandidateService() throws FileNotFoundException, IOException {
		candidateRepository = new CandidateRepository();
	}
			
	@Override
	public boolean isEmailexists(String email) throws ClassNotFoundException, SQLException {
		return candidateRepository.isEmailexists(email);
	}

	@Override
	public boolean createExperienceCandidate(String firstName, String lastName, String phone, String email,
			String passWord, int ExpInYear, ProSkill proSkill) throws ClassNotFoundException, SQLException {
		return candidateRepository.createExperienceCandidate(firstName, lastName, phone, email, passWord, ExpInYear, proSkill);
	}

	@Override
	public boolean createFresherCandidate(String firstName, String lastName, String phone, String email,
			String passWord, GraduationRank graduationRank) throws ClassNotFoundException, SQLException {
		return candidateRepository.createFresherCandidate(firstName, lastName, phone, email, passWord, graduationRank);
	}

	@Override
	public boolean loginCandidate(String email, String passWord) throws ClassNotFoundException, SQLException {
		return candidateRepository.loginCandidate(email, passWord);
	}

}
