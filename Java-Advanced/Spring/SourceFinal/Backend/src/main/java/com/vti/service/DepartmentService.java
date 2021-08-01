package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForUpdating;
import com.vti.repository.IDepartmentRepository;
import com.vti.specification.AccountSpecification;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository depRepository;

	@Override
	public List<Department> getAllDepartments() {
		return depRepository.findAll();
	}

//	@Override
//	public Page<Department> getAllDepartment(Pageable pageable, String search) {
//			Specification<Department> where = null;
//		
//		if (!StringUtils.isEmpty(search)) {
//			AccountSpecification nameSpecification = new AccountSpecification("fullname", "LIKE", search);
//
//			AccountSpecification emailSpecification = new AccountSpecification("email", "LIKE", search);
//
//			AccountSpecification departmentSpecification = new AccountSpecification("department.name", "LIKE", search);
//
//			where = Specification.where(nameSpecification).or(emailSpecification).or(departmentSpecification);
//
//		}
//		return depRepository.findAll(where, pageable);
//	}
	
	@Override
	public Department getDepartmentByID(short id) {
		return depRepository.findById(id).get();
	}

	@Override
	public Department getDepartmentByName(String name) {
		return depRepository.findByName(name);
	}

	@Override
	public void createDepartment(DepartmentFormForCreating form) {
		Department department = new Department(form.getName());

		depRepository.save(department);
	}

	@Override
	public void updateDepartment(short id, DepartmentFormForUpdating form) {
		Department department = getDepartmentByID(id);
		department.setName(form.getName());
		depRepository.save(department);
	}

	@Override
	public void deleteDepartment(short id) {
		depRepository.deleteById(id);
	}

	@Override
	public boolean isDepartmentExistsByID(short id) {
		return depRepository.existsById(id);
	}

	@Override
	public boolean isDepartmentExistsByName(String name) {
		return depRepository.existsByName(name);
	}

	

}
