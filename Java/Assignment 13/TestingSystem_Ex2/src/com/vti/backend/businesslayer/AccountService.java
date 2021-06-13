package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.IAccountRepository;
import com.vti.entity.Account;
import com.vti.entity.Manager;

public class AccountService implements IAccountService{
	private IAccountRepository accountRepository;
	
	public AccountService() throws FileNotFoundException, IOException {
		accountRepository = new AccountRepository();
	}

	@Override
	public Boolean isAccountEmailExists(String email) throws ClassNotFoundException, SQLException {
		return accountRepository.isAccountEmailExists(email);
	}

	@Override
	public Boolean loginAccount(String email, String password) throws ClassNotFoundException, SQLException {
		return accountRepository.loginAccount(email, password);
	}

	@Override
	public List<Account> findAccountByProjectID(int projectID)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		return accountRepository.findAccountByProjectID(projectID);
	}

	@Override
	public List<Manager> accountManagerInProject(int projectID)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		return accountRepository.accountManagerInProject(projectID);
	}
}
