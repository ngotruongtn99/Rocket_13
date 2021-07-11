package com.vti.service;

import java.util.List;

import com.vti.datalayer.DepartmentRepository;
import com.vti.entity.Department;

public class DepartmentService {

	private DepartmentRepository depRepository;
	
	public DepartmentService() {
		depRepository = new DepartmentRepository();
	}
	
	public List<Department> getListDepartment() {
		return depRepository.getListDepartment();
		}
}
