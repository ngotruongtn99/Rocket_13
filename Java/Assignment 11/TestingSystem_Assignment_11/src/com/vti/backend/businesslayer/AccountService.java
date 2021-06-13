package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.IAccountRepository;
import com.vti.entity.Account;

public class AccountService implements IAccountService {
	private IAccountRepository accountRepository;
	
	public AccountService() throws FileNotFoundException, IOException {
		accountRepository = new AccountRepository();
	}
	
	@Override
	public List<Account> getListAccounts() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		return accountRepository.getListAccounts();
		
	}

	@Override
	public Account getAccountById(int id)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return accountRepository.getAccountById(id);
	}

	@Override
	public boolean isAccountNameExists(String username) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRepository.isAccountNameExists(username);
	}

	@Override
	public boolean isAccountEmailExists(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRepository.isAccountEmailExists(email);
	}

	@Override
	public boolean createAccount(Account acc, int depId, int posId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRepository.createAccount(acc, depId, posId);
	}

	@Override
	public boolean updateAccountUserName(int id, String newUserName)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return accountRepository.updateAccountUserName(id, newUserName);
	}

	@Override
	public boolean updateAccountEmail(int id, String newEmail)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return accountRepository.updateAccountEmail(id, newEmail);
	}

	@Override
	public boolean updateAccountFullname(int id, String fullname)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return accountRepository.updateAccountFullname(id, fullname);
	}

	@Override
	public boolean updateAccountDep(int id, int dep)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return accountRepository.updateAccountDep(id, dep);
	}

	@Override
	public boolean updateAccountPos(int id, int pos)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return accountRepository.updateAccountPos(id, pos);
	}

	@Override
	public boolean delAccount(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return accountRepository.delAccount(id);
	}
}
