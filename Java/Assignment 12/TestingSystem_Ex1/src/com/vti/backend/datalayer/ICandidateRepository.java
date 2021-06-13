package com.vti.backend.datalayer;

import java.sql.SQLException;

import com.vti.entity.ExperienceCandidate.ProSkill;
import com.vti.entity.FresherCandidate.GraduationRank;

public interface ICandidateRepository {
	public boolean isEmailexists(String email) throws ClassNotFoundException, SQLException;
	public boolean createExperienceCandidate(String firstName, String lastName, String phone, String email,
			String passWord, int ExpInYear, ProSkill proSkill) throws ClassNotFoundException, SQLException;
	
	public boolean createFresherCandidate(String firstName, String lastName, String phone, String email,
			String passWord, GraduationRank graduationRank) throws ClassNotFoundException, SQLException;
	
	public boolean loginCandidate(String email, String passWord) throws ClassNotFoundException, SQLException;
}