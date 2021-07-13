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

import com.vti.dto.AccountDto;
import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
public class AccountController {

	@Autowired
	private IAccountService accService;

	@GetMapping
	public ResponseEntity<?> getAllAccount() {
		List<Account> list = accService.getAllAccount();

		List<AccountDto> dtos = new ArrayList<>();
		for (Account entity : list) {
			AccountDto dto = new AccountDto(entity.getId(), entity.getFullname(), entity.getDepartment().getName(),
					entity.getPosition().getName().name(), entity.getCreateDate());
			dtos.add(dto);
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable(name = "id") short id) {
		Account account = accService.getAccountById(id);
		AccountDto dto = new AccountDto(account.getId(), account.getFullname(), account.getDepartment().getName(),
				account.getPosition().getName().name(), account.getCreateDate());

		return new ResponseEntity<>(dto, HttpStatus.OK);

	}

	@PostMapping()
	public ResponseEntity<?> createAccount(@RequestBody AccountFormForCreating form) {
		accService.createAccount(form);

		return new ResponseEntity<String>("Create Completed !", HttpStatus.CREATED);

	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<?> updateAccount(@PathVariable(name = "id") short id,
			@RequestBody AccountFormForUpdating form) {
		accService.updateAccount(id, form);

		return new ResponseEntity<String>("Update Completed !", HttpStatus.OK);

	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") short id) {
		accService.deleteAccount(id);
		return new ResponseEntity<String>("Delete Completed !", HttpStatus.OK);

	}

}
