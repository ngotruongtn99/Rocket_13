package com.vti.backend;

import java.time.LocalDate;

import com.vti.entity.Account;

public class Exercise2 {
	
	public void Question1() {
		System.out.println("---------------------Question 1----------------------");
		Account[] accArray = new Account[5];
		for (int i = 0; i < accArray.length; i++) {
			Account acc = new Account("Email " + (i+1), "username " + (i+1), "fullname " + (i+1), LocalDate.now());
			accArray[i] = acc;
			System.out.println("Thông tin Account: "+ (i+1) + accArray[i].toString());
			
		}
	}
}
