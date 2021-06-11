package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.DepartmentRepository;
import com.vti.entity.Department;

public class DepartmentService implements IDepartmentService{
	private DepartmentRepository departmentRepository;

	public DepartmentService() throws FileNotFoundException, IOException {
		departmentRepository = new DepartmentRepository();
	}

	@Override
	public List<Department> getDepartments() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentRepository.getDepartments();
	}

	@Override
	public Department getDepartmentById() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentRepository.getDepartmentById();
	}

	@Override
	public Department getDepartmentById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentRepository.getDepartmentById(id);
	}

	@Override
	public Boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return departmentRepository.isDepartmentNameExists(name);
	}

	@Override
	public Boolean isDepartmentIdExists(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return departmentRepository.isDepartmentIdExists(id);
	}

	@Override
	public boolean createDepartment(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentRepository.createDepartment(name);
	}

	@Override
	public boolean updateDepartmentName(int id, String newName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentRepository.updateDepartmentName(id, newName);
	}

	@Override
	public boolean deleteDepartment(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentRepository.deleteDepartment(id);
	}
	
	
}
