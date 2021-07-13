package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.DepartmentDto;
import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForUpdating;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private IDepartmentService depService;

	@GetMapping
	public ResponseEntity<?> getAllDepartments() {
		List<Department> list = depService.getAllDepartments();

		// convert entities --> dtos
		List<DepartmentDto> dtos = new ArrayList<>();
		for (Department entity : list) {
			DepartmentDto dto = new DepartmentDto(entity.getId(), entity.getName());
			dtos.add(dto);
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "id") short id) {
		return new ResponseEntity<Department>(depService.getDepartmentByID(id), HttpStatus.OK);
	}

	@GetMapping(value = "/name/{name}")
	public ResponseEntity<?> getDepartmentByName(@PathVariable(name = "name") String name) {
		return new ResponseEntity<Department>(depService.getDepartmentByName(name), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentFormForCreating form) {

		depService.createDepartment(form);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id,
			@RequestBody DepartmentFormForUpdating form) {
		depService.updateDepartment(id, form);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
		depService.deleteDepartment(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
