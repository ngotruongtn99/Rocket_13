package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Manager;

public interface IAccountService {
	public Boolean isAccountEmailExists(String email) throws ClassNotFoundException, SQLException;
	public Boolean	loginAccount(String email, String password) throws ClassNotFoundException, SQLException;
	public List<Account>	findAccountByProjectID(int projectID) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	public List<Manager>	accountManagerInProject(int projectID) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	

}
