package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.ultis.jdbcUltis;

import sun.awt.windows.WLightweightFramePeer;

public class DepartmentRepository implements IDepartmentRepository {
private jdbcUltis jdbc;
	
	public DepartmentRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	
	@Override
	public Department getDepartmentById(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department WHERE DepartmentID = ? ;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Department dep = new Department(resultSet.getInt(1), resultSet.getString(2));
			jdbc.disConnection();
			return dep;
			
		} else {
			jdbc.disConnection();
			return null;
		}
		
		
	}

	@Override
	public List<Department> getDepartments() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department ORDER BY DepartmentID;";
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Department> list = new ArrayList<Department>();
		while (resultSet.next()) {
			Department dep = new Department(resultSet.getInt(1), resultSet.getString(2));
			list.add(dep);
		}
		jdbc.disConnection();
		return list;
	}
	
	@Override
	public Boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM Department WHERE DepartmentName = ?";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, name);
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
	public boolean createDepartment(String name) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO Department (DepartmentName) VALUES (?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, name);
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
	public boolean updateDepartmentName(int id, String newName) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE Department SET DepartmentName = ? WHERE (DepartmentID = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, newName);
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
	public boolean deleteDepartment(int id) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM Department WHERE DepartmentID = ?;";
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
