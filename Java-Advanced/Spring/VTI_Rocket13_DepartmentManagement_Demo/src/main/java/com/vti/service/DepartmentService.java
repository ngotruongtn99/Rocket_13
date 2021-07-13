package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForUpdating;
import com.vti.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository depRepository;

	public List<Department> getAllDepartments() {
		return depRepository.findAll();
	}

	public Department getDepartmentByID(short id) {
		return depRepository.findById(id).get();
	}

	public Department getDepartmentByName(String name) {
		return depRepository.findByName(name);
	}

	public void createDepartment(DepartmentFormForCreating form) {
		Department department = new Department(form.getName());

		depRepository.save(department);
	}

	public void updateDepartment(short id, DepartmentFormForUpdating form) {
		Department department = getDepartmentByID(id);
		department.setName(form.getName());
		depRepository.save(department);
	}

	public void deleteDepartment(short id) {
		depRepository.deleteById(id);
	}

	public boolean isDepartmentExistsByID(short id) {
		return depRepository.existsById(id);
	}

	public boolean isDepartmentExistsByName(String name) {
		return depRepository.existsByName(name);
	}

}
