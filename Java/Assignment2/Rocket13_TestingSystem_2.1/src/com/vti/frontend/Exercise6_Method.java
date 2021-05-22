package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class Exercise6_Method {

	public static void main(String[] args) {
//		Question 1:
		System.out.println("\n--------------METHOD Question 1--------------");
		Question1();
		
//		Question 2:
		System.out.println("\n--------------METHOD Question 2--------------");
		AccountInformation();
		
//		Question 3:
		System.out.println("\n--------------METHOD Question 3--------------");
		Question3();
	}
	

	private static void Question3() {
		System.out.print("Các số nguyên dương nhỏ hơn 10 là: ");
		for (int i = 0; i < 10; i++) {
			System.out.print(i + " ");
		}
		
	}


	private static void AccountInformation() {
		//Tạo Department
		
				Department dep1 = new Department();
				dep1.id = 1;
				dep1.name = "Giám đốc";
				
				Department dep2 = new Department();
				dep2.id = 2;
				dep2.name = "Marketing";
				
				Department dep3 = new Department();
				dep3.id = 3;
				dep3.name = "Sale";
				
				//Tạo Positon
				
				Position pos1 = new Position();
				pos1.id = 1;
				pos1.name = PositionName.DEV;
				
				Position pos2 = new Position();
				pos2.id = 2;
				pos2.name = PositionName.TEST;
				
				Position pos3 = new Position();
				pos3.id = 3;
				pos3.name = PositionName.SCRUM_MASTER;
				
				Position pos4 = new Position();
				pos4.id = 4;
				pos4.name = PositionName.PM;
				
				//Tạo Group
				
				Group group1 = new Group();
				group1.id = 1;
				group1.name = "VTIAcademy1";
				group1.createDate = LocalDate.of(2021, 01, 31);
						
				Group group2 = new Group();
				group2.id = 2;
				group2.name = "VTIAcademy2";
				group1.createDate = LocalDate.of(2021, 02, 12);
				
				Group group3 = new Group();
				group3.id = 3;
				group3.name = "VTIAcademy3";
				group1.createDate = LocalDate.of(2021, 04, 30);
						
				//Tạo Account
				
				Account acc1 = new Account();
				acc1.id = 1;
				acc1.email = "email1@gmail.com";
				acc1.fullname = "fullname1";
				acc1.username = "username1";
				acc1.department = dep1;
				acc1.position = pos1;
				acc1.createDate = LocalDate.of(2021, 03, 17);
				
				Account acc2 = new Account();
				acc2.id = 2;
				acc2.email = "email2@gmail.com";
				acc2.fullname = "fullname2";
				acc2.username = "username2";
				acc2.department = dep2;
				acc2.position = pos2;
				acc2.createDate = LocalDate.of(2021, 05, 12);
				
				Account acc3 = new Account();
				acc3.id = 3;
				acc3.email = "email1@gmail.com";
				acc3.fullname = "fullname3";
				acc3.username = "username3";
				acc3.department = dep3;
				acc3.position = pos3;
				acc3.createDate = LocalDate.of(2021, 03, 30);
				Account[] accArray = {acc1, acc2, acc3};
	
		for (int i = 0; i < accArray.length; i++) {
			System.out.println("Thông tin Account " + accArray[i].id + " là:");
			System.out.println("ID: " + accArray[i].id);
			System.out.println("Email: " + accArray[i].email);
			System.out.println("Username: " + accArray[i].username);
			System.out.println("Fullname: " + accArray[i].fullname);
			System.out.println("Department: " + accArray[i].department.name);
			System.out.println("Position: " + accArray[i].position.name);
			System.out.println("CreateDate: " + accArray[i].createDate);
		}
	}

	private static void Question1() {
		System.out.print("Các số chẵn nguyên dương nhỏ hơn 10 là: ");
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
			System.out.print(i + " ");
			}
		}
	}

}
