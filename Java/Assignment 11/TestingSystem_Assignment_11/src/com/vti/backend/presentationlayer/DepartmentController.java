package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.DepartmentService;
import com.vti.entity.Department;

public class DepartmentController {
	private DepartmentService departmentService;
	
	
	public DepartmentController() throws FileNotFoundException, IOException {
		departmentService = new DepartmentService();
	}
	
	
	public List<Department> getDepartments() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentService.getDepartments();
	}

	public Department getDepartmentById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentService.getDepartmentById(id);
	}
	
	public Boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return departmentService.isDepartmentNameExists(name);
	}
	
	
	public boolean createDepartment(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentService.createDepartment(name);
	}
	
	public boolean updateDepartmentName(int id, String newName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentService.updateDepartmentName(id, newName);
	}
	
	public boolean deleteDepartment(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentService.deleteDepartment(id);
	}
}
