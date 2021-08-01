package com.vti.controller;

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

//	@GetMapping()
//	public ResponseEntity<?> getAllAccount() {
//		List<Account> list = accService.getAllAccount();
//
//		List<AccountDto> dtos = new ArrayList<>();
//		for (Account entity : list) {
//			AccountDto dto = new AccountDto(entity.getId(), entity.getEmail(), entity.getUsername(),
//					entity.getFullname(), entity.getDepartment().getName(), entity.getPosition().getName().toString(),
//					entity.getCreateDate());
//			dtos.add(dto);
//		}
//		return new ResponseEntity<>(dtos, HttpStatus.OK);
//
//	}

	// Phân trang Account

	@GetMapping()
	public ResponseEntity<?> getAllAccount(Pageable pageable, @RequestParam(required = false) String search) {
		Page<Account> entities = accService.getAllAccount(pageable, search);

		Page<AccountDto> dtoPage = entities.map(new Function<Account, AccountDto>() {

			@Override
			public AccountDto apply(Account account) {
				AccountDto dto = new AccountDto(account.getId(), account.getEmail(), account.getUsername(),
						account.getFullname(), account.getDepartment().getName(),
						account.getPosition().getName().toString(), account.getCreateDate());
				return dto;
			}
		});
		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable(name = "id") short id) {
		Account account = accService.getAccountById(id);
		AccountDto dto = new AccountDto(account.getId(), account.getEmail(), account.getUsername(),
				account.getFullname(), account.getDepartment().getName(), account.getPosition().getName().toString(),
				account.getCreateDate());

		return new ResponseEntity<>(dto, HttpStatus.OK);

	}

	@GetMapping(value = "/UsernameExists/{name}")
	public ResponseEntity<?> existsByName(@PathVariable(name = "name") String name) {
		return new ResponseEntity<>(accService.existsByUsername(name),

				HttpStatus.OK);
	}

	@GetMapping(value = "/EmailExists/{email}")
	public ResponseEntity<?> existsByEmail(@PathVariable(name = "email") String email) {
		return new ResponseEntity<>(accService.existsByEmail(email), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createAccount(@RequestBody AccountFormForCreating form) {
		accService.createAccount(form);

		return new ResponseEntity<String>("Create Completed !", HttpStatus.CREATED);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateAccount(@PathVariable(name = "id") short id,@RequestBody AccountFormForUpdating form) {
		accService.updateAccount(id, form);

		return new ResponseEntity<String>("Update Completed !", HttpStatus.OK);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") short id) {
		accService.deleteAccount(id);
		return new ResponseEntity<String>("Delete Completed !", HttpStatus.OK);

	}

}
