package com.vti.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vti.entity.Account;
import com.vti.entity.AccountStatus;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.RegistrationUserToken;
import com.vti.event.OnSendRegistrationUserConfirmViaEmailEvent;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForCreatingRegister;
import com.vti.form.AccountFormForUpdating;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IPositionRepository;
import com.vti.repository.RegistrationUserTokenRepository;
import com.vti.specification.AccountSpecification;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository accRepository;

	@Autowired
	private IDepartmentRepository depRepository;

	@Autowired
	private IPositionRepository posRepository;
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	@Autowired	
	private RegistrationUserTokenRepository registrationUserTokenRepository;
	
//	Dùng để mã hóa Password
	@Autowired
	private PasswordEncoder passwordEncoder;
	


	@SuppressWarnings("deprecation")
	@Override
	public Page<Account> getAllAccount(Pageable pageable, String search) {
		Specification<Account> where = null;
		
		if (!StringUtils.isEmpty(search)) {
			AccountSpecification nameSpecification = new AccountSpecification("fullname", "LIKE", search);

			AccountSpecification emailSpecification = new AccountSpecification("email", "LIKE", search);

			AccountSpecification departmentSpecification = new AccountSpecification("department.name", "LIKE", search);

			where = Specification.where(nameSpecification).or(emailSpecification).or(departmentSpecification);

		}
		return accRepository.findAll(where, pageable);
	}

//	@Override
//	public List<Account> getAllAccount() {
//		// TODO Auto-generated method stub
//		return accRepository.findAll();
//	}

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
		Account account = accRepository.getById(id);
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

//	@Override
//	public boolean isAccountExistsByName(String name) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isEmailExists(String email) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Account account = accRepository.findByUsername(username);

		if (account == null) {
			throw new UsernameNotFoundException(username);
		}

		return new User(account.getUsername(), account.getPassword(), AuthorityUtils.createAuthorityList("user"));
	}

	@Override
	public Account getAccountByUsername(String username) {
		return accRepository.findByUsername(username);
	}

	@Override
	public Account getAccountByEmail(String email) {
		return accRepository.findByEmail(email);
	}

	@Override
	public boolean existsByUsername(String name) {
		// TODO Auto-generated method stub
		return  accRepository.existsByUsername(name);
	}

	@Override
	public boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return accRepository.existsByEmail(email);
	}

	@Override
	public void createAccountRegister(AccountFormForCreatingRegister form) {
		Account account = new Account();
		Department department = depRepository.getById(form.getDepartmentId());
		Position position = posRepository.getById(form.getPositionId());
		account.setEmail(form.getEmail());
		account.setUsername(form.getUsername());
		account.setFullname(form.getFullname());
		account.setDepartment(department);
		account.setPosition(position);
		account.setPassword(passwordEncoder.encode(form.getPassword()));
		accRepository.save(account);

		// create new user registration token
				createNewRegistrationUserToken(account);

		// send email to confirm
		sendConfirmUserRegistrationViaEmail(account.getEmail());
		
	}

	public void sendConfirmUserRegistrationViaEmail(String email) {
		eventPublisher.publishEvent(new OnSendRegistrationUserConfirmViaEmailEvent(email));
	}


	private void createNewRegistrationUserToken(Account account) {
		// create new token for confirm Registration
				final String newToken = UUID.randomUUID().toString();
				RegistrationUserToken token = new RegistrationUserToken(newToken, account);

				registrationUserTokenRepository.save(token);
		
	}

	@Override
	public void activeUser(String token) {
		RegistrationUserToken registrationUserToken = registrationUserTokenRepository.findByToken(token);

		Account account = registrationUserToken.getAccount();
		account.setStatus(AccountStatus.ACTIVE);

		accRepository.save(account);

		// remove Registration User Token
		registrationUserTokenRepository.deleteById(registrationUserToken.getId());


	}

	

}
