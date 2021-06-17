package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.User;

public interface IUserService {
	public List<User> getListUser() throws ClassNotFoundException, SQLException;
	public User getUserById(int id) throws ClassNotFoundException, SQLException;
	public Boolean deleteUserById(int id) throws ClassNotFoundException, SQLException;
	public Boolean loginUser(String email, String password) throws ClassNotFoundException, SQLException;
	public Boolean createEmployee(String email, String fullname) throws ClassNotFoundException, SQLException;
	public Boolean loginAdmin(String email, String password) throws ClassNotFoundException, SQLException;
	public Boolean isEmailExists(String email) throws ClassNotFoundException, SQLException;

}
