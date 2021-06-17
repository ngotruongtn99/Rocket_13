package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountRepository {
	public Boolean isEmailExists(String email) throws ClassNotFoundException, SQLException;
	public Boolean loginAdmin(String email, String password ) throws ClassNotFoundException, SQLException;
	public Boolean loginUser(String email, String password) throws ClassNotFoundException, SQLException;
	public List<Account> listAccountInProject(String name) throws ClassNotFoundException, SQLException;
	public Boolean createAccount(String email, String fullName) throws ClassNotFoundException, SQLException;
}
