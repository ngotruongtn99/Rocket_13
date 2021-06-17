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


	public Boolean loginAccount(String email, String password) throws ClassNotFoundException, SQLException {
		return accountService.loginAccount(email, password);
	}


	public List<Account> findAccountByProjectID(int projectID)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		return accountService.findAccountByProjectID(projectID);
	}

	
	public List<Account> accountManagerInProject()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		return accountService.accountManagerInProject();
	}
}
