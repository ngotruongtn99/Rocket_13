package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountSerivice {
public List<Account> getListAccount() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public Account getAccountById(int id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public boolean isAccountNameExists(String username) throws ClassNotFoundException, SQLException;
	
	public boolean isAccountEmailExists(String email) throws ClassNotFoundException, SQLException;
	
	public boolean createAccount (Account acc, int depId, int posId) throws ClassNotFoundException, SQLException;
	
	public boolean updateAccountUserName(int id, String newUserName) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	public boolean updateAccountEmail(int id, String newEmail) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	public boolean updateAccountFullname(int id, String fullname) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	public boolean updateAccountDep(int id, int dep) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	public boolean updateAccountPos(int id, int pos) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	public boolean delAccount(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;

}
