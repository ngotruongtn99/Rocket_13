package com.vti.controller;

import java.util.List;

import com.vti.entity.Department;
import com.vti.service.DepartmentService;

public class DepartmentController {
	private DepartmentService depService;

	public DepartmentController() {
		depService = new DepartmentService();
	}

	public List<Department> getListDepartment() {
		return depService.getListDepartment();
	}

}
