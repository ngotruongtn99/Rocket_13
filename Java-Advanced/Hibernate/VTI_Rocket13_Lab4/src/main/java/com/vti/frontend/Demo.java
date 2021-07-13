package com.vti.frontend;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;
import com.vti.ultis.ScannerUltis;

public class Demo {
public static void main(String[] args) {
	ScannerUltis sc = new ScannerUltis();
	AccountRepository accRepository = new AccountRepository();
	int id = sc.inputIntPositive();
	accRepository.deleteAccount((short) id);
}
}
