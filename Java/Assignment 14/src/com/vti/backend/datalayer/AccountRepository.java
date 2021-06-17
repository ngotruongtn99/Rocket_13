package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.ultis.jdbcUltis;

public class AccountRepository implements IAccountRepository{
	private jdbcUltis jdbc;
	
	public AccountRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	@Override
	public Boolean isEmailExists(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `Account` WHERE email = ?;";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, email);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
		
	}

	@Override
	public Boolean loginAdmin(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `Account` WHERE email = ? AND `password` = ? AND `Role` = 'ADMIN';";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, email);
		preStatement.setString(2, password);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public Boolean loginUser(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `Account` WHERE email = ? AND `password` = ? AND `Role` = 'USER';";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, email);
		preStatement.setString(2, password);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public List<Account> listAccountInProject(String name) throws ClassNotFoundException, SQLException {
		List<Account> lisAccounts = new ArrayList<Account>();
		String sql = "SELECT paa.projectId, paa.accountId, a.fullName, a.email, paa.`Role` FROM `Account` a\r\n" + 
				"INNER JOIN ProjectAndAccount paa ON a.id = paa.accountId\r\n" + 
				"INNER JOIN Project p ON p.id = paa.projectId\r\n" + 
				"WHERE Project_Name = ?;";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, name);
		ResultSet resultSet = preStatement.executeQuery();
		while (resultSet.next()) {
			Account acc = new Account();
			acc.setId(resultSet.getInt(2));
			acc.setFullname(resultSet.getNString(3));
			acc.setEmail(resultSet.getString(4));
			lisAccounts.add(acc);
		}
		return lisAccounts;
	}

	@Override
	public Boolean createAccount(String email, String fullname) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `Account` 	(email,	`password`, 	`fullName`,  	`Role`)\r\n" + 
						"VALUES					(?,		'123456', 		?, 				'USER');";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, email);
		preStatement.setNString(2, fullname);
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
		
	}

}
