package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.vti.entity.Department;
import com.vti.ultis.ScannerUltis;
import com.vti.ultis.jdbcUltis;

public class DepartmentRepository implements IDepartmentRepository {
	private jdbcUltis jdbc;

	public DepartmentRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	
	@Override
	public List<Department> getDepartments() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department ORDER BY DepartmentID;";
		ResultSet depResult = jdbc.executeQuery(sql);
		List<Department> listDep = new ArrayList<Department>();
		while (depResult.next()) {
			Department dep = new Department(depResult.getInt("DepartmentID"), depResult.getString("DepartmentName"));
		listDep.add(dep);
		}
		jdbc.disConnection();
		return listDep;
	}
	
	@Override
	public Department getDepartmentById() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department WHERE DepartmentID = ?;";
		System.out.println("Nhập vào ID: ");
		int id = ScannerUltis.inputIntPositive();
		PreparedStatement depStatement = jdbc.createPrepareStatement(sql);
		depStatement.setInt(1, id);
		ResultSet resultSet = depStatement.executeQuery();
		if (resultSet.next()) {
			Department dep = new Department(resultSet.getInt("DepartmentID"), resultSet.getString("DepartmentName"));
			jdbc.disConnection();
			return dep;
		} else {
			jdbc.disConnection();
			return null;
		}		
	}
	
	@Override
	public Department getDepartmentById(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department WHERE DepartmentID = ?;";
		PreparedStatement depStatement = jdbc.createPrepareStatement(sql);
		depStatement.setInt(1, id);
		ResultSet resultSet = depStatement.executeQuery();
		if (resultSet.next()) {
			Department dep = new Department(resultSet.getInt("DepartmentID"), resultSet.getString("DepartmentName"));
			jdbc.disConnection();
			return dep;
		} else {
			jdbc.disConnection();
			return null;
		}		
	}
	
	@Override
	public Boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM Department WHERE DepartmentName = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, name);
		ResultSet result = preStatement.executeQuery();

		if (result.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}
	
	@Override
	public Boolean isDepartmentIdExists(int id) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM Department WHERE DepartmentID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet result = preStatement.executeQuery();
		if (result.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}
	
	@Override
	public boolean createDepartment(String name) throws ClassNotFoundException, SQLException {
		isDepartmentNameExists(name);
		String sql = "INSERT INTO Department (DepartmentName) VALUES (?);";
		PreparedStatement insertStatement = jdbc.createPrepareStatement(sql);
		insertStatement.setString(1, name);
		if (insertStatement.executeUpdate() == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}
	
	
	@Override
	public boolean updateDepartmentName(int id, String newName) throws ClassNotFoundException, SQLException {
		if (isDepartmentIdExists(id) == false) {
			return false;
		} else {
			String sql = "UPDATE Department SET DepartmentName = ? WHERE (DepartmentID = ?);";
			
			PreparedStatement updateStatement = jdbc.createPrepareStatement(sql);
			updateStatement.setString(1, newName);
			updateStatement.setInt(2, id);
			int resultSet = updateStatement.executeUpdate();
			if (resultSet == 1) {
				jdbc.disConnection();
				return true;
			} else {
				jdbc.disConnection();
				return false;	
			}
			
		}
		
	}
	
	@Override
	public boolean deleteDepartment(int id) throws ClassNotFoundException, SQLException {
		if (isDepartmentIdExists(id) == false) {
			return false;
		} else {
			String sql = "DELETE FROM Department WHERE DepartmentID = ?;";
			PreparedStatement deleteStatement = jdbc.createPrepareStatement(sql);
			deleteStatement.setInt(1, id);
			if (deleteStatement.executeUpdate() == 1) {
				jdbc.disConnection();
				return true;
			} else {
				return false;
			}
		}
	}

}
