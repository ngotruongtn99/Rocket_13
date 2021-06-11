package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.vti.backend.businesslayer.AccountService;
import com.vti.entity.Account;

public class AccountController {
	private AccountService accountService;

	public AccountController() throws FileNotFoundException, IOException {
		accountService = new AccountService();
		
	}
	
	public List<Account> getListAccounts() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		return accountService.getListAccounts();
	}
	

	public Account getAccountById(int id)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return accountService.getAccountById(id);
	}


	public boolean isAccountNameExists(String username) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.isAccountNameExists(username);
	}


	public boolean isAccountEmailExists(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.isAccountEmailExists(email);
	}


	public boolean createAccount(Account acc, int depId, int posId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.createAccount(acc, depId, posId);
	}


	public boolean updateAccountUserName(int id, String newUserName)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return accountService.updateAccountUserName(id, newUserName);
	}


	public boolean updateAccountEmail(int id, String newEmail)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return accountService.updateAccountEmail(id, newEmail);
	}


	public boolean updateAccountFullname(int id, String fullname)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return accountService.updateAccountFullname(id, fullname);
	}

	
	public boolean updateAccountDep(int id, int dep)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return accountService.updateAccountDep(id, dep);
	}

	
	public boolean updateAccountPos(int id, int pos)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return accountService.updateAccountPos(id, pos);
	}

	
	public boolean delAccount(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return accountService.delAccount(id);
	}
}
