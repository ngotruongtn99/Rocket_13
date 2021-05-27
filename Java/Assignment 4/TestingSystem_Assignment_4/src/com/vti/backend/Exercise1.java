package com.vti.backend;

import java.time.LocalDate;

import com.vti.entity.Ex1.Account;
import com.vti.entity.Ex1.Department;
import com.vti.entity.Ex1.Group;
import com.vti.entity.Ex1.Position;

public class Exercise1 {
	public void Question1() {
//		a) không có parameters
		Department dep1 = new Department();
		dep1.setId(1);
		dep1.setName("Giam Doc");
		
//		b) Có 1 parameter là nameDepartment và default id của 
//		Department = 0
		
		Department dep2 = new Department("Pho Giam doc");
		
	}
	public void Question2() {
//		a) Không có parameters
		
		Account acc1 = new Account();
		
//		b) Có các parameter là id, Email, Username, FirstName, 
//		LastName (với FullName = FirstName + LastName)

		Account acc2 = new Account(1, "Email1@gmail.com", "username1", "FirstName1", "LastName1");
		
//		c) Có các parameter là id, Email, Username, FirstName, 
//		LastName (với FullName = FirstName + LastName) và 
//		Position của User, default createDate = now
		Position pos1 = new Position();
		Account acc3 = new Account(2, "Email2@gmail.com", "username2", "FirstName2", "LastName2", pos1);
		
//		d) Có các parameter là id, Email, Username, FirstName, 
//		LastName (với FullName = FirstName + LastName) và 
//		Position của User, createDate
		Position pos2 = new Position();
		Account acc4 = new Account(2, "Email3@gmail.com", "username3", "FirstName3", "LastName3", pos2, LocalDate.of(2021, 3, 21));
		
		
	}
	public void Question3() {
//		a) không có parameters
		Group group1 = new Group();
		
//		b) Có các parameter là GroupName, Creator, array Account[] 
//				accounts, CreateDate
		Account acc1 = new Account();
		Account[] accGroup1 = {acc1};
		Group group2 = new Group("Group1", acc1, LocalDate.of(2021, 2, 21), accGroup1);
		
	}
}
