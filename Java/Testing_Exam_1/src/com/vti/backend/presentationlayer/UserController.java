package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entity.User;

public class UserController {
	private IUserService userService;

	public UserController() throws FileNotFoundException, IOException {
		userService = new UserService();
	}


	public List<User> getListUser() throws ClassNotFoundException, SQLException {
		return userService.getListUser();
	}


	public User getUserById(int id) throws ClassNotFoundException, SQLException {
		return userService.getUserById(id);
	}

	
	public Boolean deleteUserById(int id) throws ClassNotFoundException, SQLException {
		return userService.deleteUserById(id);
	}


	public Boolean loginUser(String email, String password) throws ClassNotFoundException, SQLException {
		return userService.loginUser(email, password);
	}


	public Boolean createEmployee(String email, String fullname) throws ClassNotFoundException, SQLException {
		return userService.createEmployee(email, fullname);
	}


	public Boolean loginAdmin(String email, String password) throws ClassNotFoundException, SQLException {
		return userService.loginAdmin(email, password);
	}


	public Boolean isEmailExists(String email) throws ClassNotFoundException, SQLException {
		return userService.isEmailExists(email);
	}

}
