package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRopository;
import com.vti.entity.User;

public class UserService implements IUserService {
	private IUserRepository  userRepository;

	public UserService() throws FileNotFoundException, IOException {
		userRepository = new UserRopository();
	}

	@Override
	public List<User> getListUser() throws ClassNotFoundException, SQLException {
		return userRepository.getListUser();
	}

	@Override
	public User getUserById(int id) throws ClassNotFoundException, SQLException {
		
		return userRepository.getUserById(id);
	}

	@Override
	public Boolean deleteUserById(int id) throws ClassNotFoundException, SQLException {
		return userRepository.deleteUserById(id);
	}

	@Override
	public Boolean loginUser(String email, String password) throws ClassNotFoundException, SQLException {
		return userRepository.loginUser(email, password);
	}

	@Override
	public Boolean createEmployee(String email, String fullname) throws ClassNotFoundException, SQLException {
		return userRepository.createEmployee(email, fullname);
	}

	@Override
	public Boolean loginAdmin(String email, String password) throws ClassNotFoundException, SQLException {
		return userRepository.loginAdmin(email, password);
	}

	@Override
	public Boolean isEmailExists(String email) throws ClassNotFoundException, SQLException {
		return userRepository.isEmailExists(email);
	}

}
