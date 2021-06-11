package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentService {
	public List<Department> getDepartments() throws ClassNotFoundException, SQLException;

	public Department getDepartmentById() throws ClassNotFoundException, SQLException;
	
	public Department getDepartmentById(int id) throws ClassNotFoundException, SQLException;
	
	public Boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException;
	
	public Boolean isDepartmentIdExists(int id) throws SQLException, ClassNotFoundException;
	
	public boolean createDepartment(String name) throws ClassNotFoundException, SQLException;
	
	public boolean updateDepartmentName(int id, String newName) throws ClassNotFoundException, SQLException;
	
	public boolean deleteDepartment(int id) throws ClassNotFoundException, SQLException;

}
