package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentRepository {
	
	public List<Department> getDepartments() throws ClassNotFoundException, SQLException;
	
	public Department getDepartmentById(int id) throws ClassNotFoundException, SQLException;
	
	public Boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException;
	
	public boolean createDepartment(String name) throws ClassNotFoundException, SQLException;
	
	public boolean updateDepartmentName(int id, String newName) throws ClassNotFoundException, SQLException;
	
	public boolean deleteDepartment(int id) throws ClassNotFoundException, SQLException;

}
