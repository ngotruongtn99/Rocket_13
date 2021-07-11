package com.vti.service;

import java.util.List;

import com.vti.datalayer.AccountRepository;
import com.vti.entity.Account;
import com.vti.entity.dto.AccountDTO;

public class AccountService {

	private AccountRepository accRepository;

	public AccountService() {
		accRepository = new AccountRepository();
	}

	public List<Account> getAllAccount() {
		return accRepository.getAllAccount();
	}

	public void createAccount(AccountDTO accDTO) {
		Account entity = accDTO.toEntity();
		accRepository.createAccount(entity);
	}

	public Account getAccountByEmail(String email) {
		return accRepository.getAccountByEmail(email);
	}

	public boolean isAccountExistsByEmail(String email) {
		return accRepository.isAccountExistsByEmail(email);
	}
}
