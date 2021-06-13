package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Manager;
import com.vti.entity.Project;
import com.vti.ultis.jdbcUltis;

public class AccountRepository implements IAccountRepository {
	private jdbcUltis jdbc;
	
	public AccountRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	@Override
	public Boolean isAccountEmailExists(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Account WHERE Email = ?";
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
	public Boolean loginAccount(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Account WHERE Email = ? AND password = ?";
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
		String sql = "SELECT * FROM vw_AccInProject WHERE ProjectID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, projectID);
		ResultSet resultSet = preStatement.executeQuery();
		List<Account> list = new ArrayList<Account>();
		while (resultSet.next()) {
			Account acc = new Account();
			acc.setId(resultSet.getInt(1));
			acc.setFullname(resultSet.getNString(2));
			acc.setEmail(resultSet.getString(3));
			acc.setPassword(resultSet.getString(4));
			acc.setPosition(resultSet.getString(5));
			ProjectRepository projectRepository = new ProjectRepository();
			Project project = projectRepository.getProjectByID(resultSet.getInt(6));
			acc.setProject(project);
			list.add(acc);
		}
		return list;
	}

	@Override
	public List<Manager> accountManagerInProject(int projectID) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT a.id, a.FullName, a.Email, a.`password`, a.expInYear, a.ProjectID FROM `Account` a \r\n" + 
				"INNER JOIN Project p ON a.ProjectID = p.ProjectID\r\n" + 
				"WHERE Category = 'Manager' AND ProjectID = ?; ";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, projectID);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Manager> list = new ArrayList<Manager>();
		while (resultSet.next()) {
			Manager manager = new Manager();
			manager.setId(resultSet.getInt(1));
			manager.setFullname(resultSet.getNString(2));
			manager.setEmail(resultSet.getString(3));
			manager.setPassword(resultSet.getString(4));
			manager.setExpInYear(resultSet.getInt(5));
			ProjectRepository projectRepository = new ProjectRepository();
			Project project = projectRepository.getProjectByID(resultSet.getInt(6));
			manager.setProject(project);
			list.add(manager);
			
		} 
		return list;
	}
	
}
