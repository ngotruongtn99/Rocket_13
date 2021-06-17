package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.IAccountService;
import com.vti.entity.Account;

public class AccountController {
	private IAccountService accountService;
	
	public AccountController() throws FileNotFoundException, IOException {
		accountService = new AccountService();
	}
	

	public Boolean isEmailExists(String email) throws ClassNotFoundException, SQLException {
		return accountService.isEmailExists(email);
	}


	public Boolean loginAdmin(String email, String password) throws ClassNotFoundException, SQLException {
		return accountService.loginAdmin(email, password);
	}


	public Boolean loginUser(String email, String password) throws ClassNotFoundException, SQLException {
		return accountService.loginUser(email, password);
	}


	public List<Account> listAccountInProject(String name) throws ClassNotFoundException, SQLException {
		return accountService.listAccountInProject(name);
	}


	public Boolean createAccount(String email, String fullName) throws ClassNotFoundException, SQLException {
		return accountService.createAccount(email, fullName);
	}
}
