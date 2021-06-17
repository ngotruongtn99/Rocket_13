package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.User;
import com.vti.ultis.jdbcUltis;

public class UserRopository implements IUserRepository {
	private jdbcUltis jdbc;

	public UserRopository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public List<User> getListUser() throws ClassNotFoundException, SQLException {
		List<User> listUser = new ArrayList<User>();
		String sql = "SELECT id, `email`, `fullName` FROM `User`;";
		ResultSet resultSet = jdbc.executeQuery(sql);
		while (resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getInt(1));
			user.setEmail(resultSet.getString(2));
			user.setFullname(resultSet.getNString(3));
			listUser.add(user);
		}
		return listUser;
	}

	@Override
	public User getUserById(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT id, `email`, `fullName` FROM `User` WHERE ID = ?;";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();
		User user = new User();
		if (resultSet.next()) {
			user.setId(resultSet.getInt(1));
			user.setEmail(resultSet.getString(2));
			user.setFullname(resultSet.getNString(3));
			jdbc.disConnection();
			return user;
		} else {
			jdbc.disConnection();
			return null;
		}
		
		
	}

	@Override
	public Boolean deleteUserById(int id) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM `User` WHERE ID = ?;";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		int resultSet = preStatement.executeUpdate();
		if (resultSet == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public Boolean loginUser(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `User` WHERE email = ? AND `password` = ?;";
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
	public Boolean createEmployee(String email, String fullname) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `User` (`email`,	`password`,		`fullName` , 	`Role`)\r\n" + 
				"VALUES				(?, '123456', 		?, 'EMPLOYEE');";
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

	@Override
	public Boolean loginAdmin(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `User` WHERE email = ? AND `password` = ? AND `role` = 'ADMIN';";
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
	public Boolean isEmailExists(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `User` WHERE email = ?;";
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

}
