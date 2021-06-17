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

public class AccountRepository implements IAccountRepository {
	private jdbcUltis jdbc;
	
	public AccountRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public Boolean loginAccount(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `user` WHERE email= ? AND `password` = ?";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
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
	public List<Account> findAccountByProjectID(int projectID) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT 	pau.projectId, u.`fullName`, u.`email`, pau.`Role` FROM	`ProjectAndUser` pau JOIN	`User` u	ON u.id = pau.userId WHERE	pau.projectId = ?;";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, projectID);
		ResultSet resultSet = preStatement.executeQuery();
		List<Account> list = new ArrayList<Account>();
		while (resultSet.next()) {
			Account acc = new Account();
			acc.setId(resultSet.getInt(1));
			acc.setFullname(resultSet.getNString(2));
			acc.setEmail(resultSet.getString(3));
			list.add(acc);
		}
		return list;
	}

	@Override
	public List<Account> accountManagerInProject() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT pau.projectId,u.`email`, u.`fullName`, pau.`Role` FROM	`ProjectAndUser` pau JOIN	`User` u	ON u.id = pau.userId WHERE	`Role` = 'MANAGER';";
		
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Account> list = new ArrayList<Account>();
		while (resultSet.next()) {
			Account account = new Account();
			account.setId(resultSet.getInt(1));
			account.setEmail(resultSet.getString(2));
			account.setFullname(resultSet.getString(3));
			list.add(account);
			
		} 
		return list;
	}
	
}
