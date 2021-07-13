package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IPositionRepository;

@Service
public class AccountService implements IAccountService{
	
	@Autowired
	private IAccountRepository accRepository;

	@Autowired
	private IDepartmentRepository depRepository;
	
	@Autowired
	private IPositionRepository posRepository;
	
	@Override
	public List<Account> getAllAccount() {
		
		return accRepository.findAll();
	}


	@Override
	public Account getAccountById(short id) {
		return accRepository.findById(id).get();
	}


	@Override
	public Account getAccountByName(String name) {
		return null;
	}


	@Override
	public void createAccount(AccountFormForCreating form) {
		Account account = new Account();
		Department department = depRepository.getById(form.getDepartmentID());
		Position position = posRepository.getById(form.getPositionID());
		account.setEmail(form.getEmail());
		account.setFullname(form.getFullname());
		account.setUsername(form.getUsername());
		account.setDepartment(department);
		account.setPosition(position);
		accRepository.save(account);
	}


	@Override
	public void updateAccount(short id, AccountFormForUpdating form) {
		Account account = new Account();
		Department department = depRepository.getById(form.getDepartmentID());
		Position position = posRepository.getById(form.getPositionID());
		account.setFullname(form.getFullname());
		account.setDepartment(department);
		account.setPosition(position);
		accRepository.save(account);
	}


	@Override
	public void deleteAccount(short id) {
		accRepository.deleteById(id);
	}


	@Override
	public boolean isAccountExistsByID(short id) {
		// TODO Auto-generated method stub
		return accRepository.existsById(id);
	}


	@Override
	public boolean isAccountExistsByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isEmailExists(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
