package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.entity.ExperienceCandidate.ProSkill;
import com.vti.entity.FresherCandidate.GraduationRank;
import com.vti.ultis.jdbcUltis;

public class CandidateRepository implements ICandidateRepository{

	private jdbcUltis jdbc;
	
	public CandidateRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	
	
	@Override
	public boolean isEmailexists(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Candidate WHERE email = ?";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	
	}

	@Override
	public boolean createExperienceCandidate(String firstName, String lastName, String phone, String email,
			String passWord, int ExpInYear, ProSkill proSkill) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO Candidate (FirstName, LastName, Phone, Email, password, expInYear, ProSkill, Category) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, 'EXPERIENCECANDIDATE')";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setNString(1, firstName);
		preparedStatement.setNString(2, lastName);
		preparedStatement.setString(3, phone);
		preparedStatement.setString(4, email);
		preparedStatement.setString(5, passWord);
		preparedStatement.setInt(6, ExpInYear);
		preparedStatement.setString(7, proSkill.toString());
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean createFresherCandidate(String firstName, String lastName, String phone, String email,
			String passWord, GraduationRank graduationRank) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO Candidate (FirstName, LastName, Phone, Email, password, GraduationRank, Category) VALUES "
				+ "(?, ?, ?, ?, ?, ?, 'FRESHERCANDIDATE')";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setNString(1, firstName);
		preparedStatement.setNString(2, lastName);
		preparedStatement.setString(3, phone);
		preparedStatement.setString(4, email);
		preparedStatement.setString(5, passWord);
		preparedStatement.setString(6, graduationRank.toString());
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean loginCandidate(String email, String passWord) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Candidate WHERE Email = ? AND password = ?";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, passWord);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

}
