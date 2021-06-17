package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.IAccountRepository;
import com.vti.entity.Account;

public class AccountService implements IAccountService {
	private IAccountRepository accRepository;
	
	public AccountService() throws FileNotFoundException, IOException {
		accRepository = new AccountRepository();
	}

	@Override
	public Boolean isEmailExists(String email) throws ClassNotFoundException, SQLException {
		return accRepository.isEmailExists(email);
	}

	@Override
	public Boolean loginAdmin(String email, String password) throws ClassNotFoundException, SQLException {
		return accRepository.loginAdmin(email, password);
	}

	@Override
	public Boolean loginUser(String email, String password) throws ClassNotFoundException, SQLException {
		return accRepository.loginUser(email, password);
	}

	@Override
	public List<Account> listAccountInProject(String name) throws ClassNotFoundException, SQLException {
		return accRepository.listAccountInProject(name);
	}

	@Override
	public Boolean createAccount(String email, String fullName) throws ClassNotFoundException, SQLException {
		return accRepository.createAccount(email, fullName);
	}
}
