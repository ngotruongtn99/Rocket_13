package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.ultis.jdbcUltis;

public class AccountRepository implements IAccountRepository {
	private jdbcUltis jdbc;

	public AccountRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public List<Account> getListAccounts()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM Account ORDER BY AccountID;";
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Account> list = new ArrayList<Account>();
		while (resultSet.next()) {
			Account acc = new Account();
			acc.setId(resultSet.getInt(1));
			acc.setEmail(resultSet.getString(2));
			acc.setUsername(resultSet.getString(3));
			acc.setFullname(resultSet.getString(4));

			DepartmentRepository departmentRepository = new DepartmentRepository();
			Department department = departmentRepository.getDepartmentById(resultSet.getInt(5));
			acc.setDepartment(department);

			PositionRepository positionRepository = new PositionRepository();
			Position position = positionRepository.getPositionById(resultSet.getInt(6));
			acc.setPosition(position);

			LocalDate lcd = resultSet.getDate(7).toLocalDate();
			acc.setCreateDate(lcd);

			list.add(acc);

		}
		return list;

	}

	@Override
	public Account getAccountById(int id)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM Account WHERE AccountID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Account acc = new Account();
			acc.setId(resultSet.getInt(1));
			acc.setEmail(resultSet.getString(2));
			acc.setUsername(resultSet.getString(3));
			acc.setFullname(resultSet.getString(4));

			DepartmentRepository departmentRepository = new DepartmentRepository();
			Department department = departmentRepository.getDepartmentById(resultSet.getInt(5));
			acc.setDepartment(department);

			PositionRepository positionRepository = new PositionRepository();
			Position position = positionRepository.getPositionById(resultSet.getInt(6));
			acc.setPosition(position);

			LocalDate lcd = resultSet.getDate(7).toLocalDate();
			acc.setCreateDate(lcd);
			jdbc.disConnection();
			return acc;
		} else {
			jdbc.disConnection();
			return null;
		}

	}

	@Override
	public boolean isAccountNameExists(String username) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Account WHERE Username = ? ;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, username);
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
	public boolean isAccountEmailExists(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Account WHERE Email = ? ;";
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
	public boolean createAccount(Account acc, int depId, int posId) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO Account (Email, Username, Fullname, DepartmentID, PositionID, Createdate) VALUES (?, ?, ?, ?, ?, now())";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, acc.getEmail());
		preparedStatement.setString(2, acc.getUsername());
		preparedStatement.setString(3, acc.getFullname());
		preparedStatement.setInt(4, depId);
		preparedStatement.setInt(5, posId);
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
	public boolean updateAccountUserName(int id, String newUserName)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		String sql = "UPDATE Account SET Username = ? WHERE (AccountID = ?)";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, newUserName);
		preparedStatement.setInt(2, id);
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
	public boolean updateAccountEmail(int id, String newEmail)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		String sql = "UPDATE Account SET Email = ? WHERE (AccountID = ?)";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, newEmail);
		preparedStatement.setInt(2, id);
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
	public boolean updateAccountFullname(int id, String fullname)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		String sql = "UPDATE Account SET Fullname = ? WHERE (AccountID = ?)";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, fullname);
		preparedStatement.setInt(2, id);
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
	public boolean updateAccountDep(int id, int dep)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		String sql = "UPDATE Account SET DepartmentID = ? WHERE (AccountID = ?)";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, dep);
		preparedStatement.setInt(2, id);
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
	public boolean updateAccountPos(int id, int pos)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		String sql = "UPDATE Account SET PositionID = ? WHERE (AccountID = ?)";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, pos);
		preparedStatement.setInt(2, id);
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
	public boolean delAccount(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		String sql = "DELETE FROM Account WHERE AccountID = ?";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

}
