package com.vti.frontend;

import java.util.List;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class Demo {
	public static void main(String[] args) {
		DepartmentRepository depRepository = new DepartmentRepository();

//	List<Department> list =  depRepository.getAllDepartment();
//	for (Department department : list) {
//		System.out.println("ID " + department.getId() + ", Name " + department.getName());
//	}

//		Department dep = new Department();
//		dep = depRepository.getDepartmentById((short) 3);
//		System.out.println("ID " + dep.getId() + ", Name " + dep.getName());

//		Department dep = new Department();
//		dep = depRepository.getDepartmentByName("Giám đốc");
//		System.out.println("ID " + dep.getId() + ", Name " + dep.getName());
//		Department dep = new Department();
//		dep.setName("Developer");
//		depRepository.createDepartment(dep);
		
		List<Department> list =  depRepository.getAllDepartment();
		for (Department department : list) {
			System.out.println("ID: " + department.getId() + ", Name: " + department.getName());
		}
	}
}
