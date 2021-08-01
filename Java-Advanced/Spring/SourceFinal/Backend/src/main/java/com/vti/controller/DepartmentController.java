package com.vti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDto;
import com.vti.dto.DepartmentDto;
import com.vti.entity.Account;
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
			AccountDto accDto = new AccountDto(entity.getCreator().getId(), entity.getCreator().getEmail(),
					entity.getCreator().getUsername(), entity.getCreator().getFullname(),
					entity.getCreator().getDepartment().getName(),
					entity.getCreator().getPosition().getName().toString(), entity.getCreator().getCreateDate());
			DepartmentDto dto = new DepartmentDto(entity.getId(), entity.getName(), accDto, entity.getCreateDate());
			dtos.add(dto);
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

//	@GetMapping()
//	public ResponseEntity<?> getAllDepartment(Pageable pageable, @RequestParam(required = false) String search) {
//		Page<Account> entities = accService.getAllAccount(pageable, search);
//
//		Page<AccountDto> dtoPage = entities.map(new Function<Account, AccountDto>() {
//
//			@Override
//			public AccountDto apply(Account account) {
//				AccountDto dto = new AccountDto(account.getId(), account.getEmail(), account.getUsername(),
//						account.getFullname(), account.getDepartment().getName(),
//						account.getPosition().getName().toString(), account.getCreateDate());
//				return dto;
//			}
//		});
//		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
//	}

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

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
		depService.deleteDepartment(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
