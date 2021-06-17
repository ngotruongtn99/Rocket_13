package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountRepository {
	public Boolean loginAccount(String email, String password) throws ClassNotFoundException, SQLException;
	public List<Account> findAccountByProjectID(int projectID) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	public List<Account> accountManagerInProject() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
}
