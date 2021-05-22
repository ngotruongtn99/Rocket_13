package com.vti.frontend;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class Exercise5_InputFromConsole {

	public static void main(String[] args) {
		
//		Question 1: Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
		
		System.out.println("--------------INPUT FROM CONSOLE Question 1--------------");
		Scanner sc = new Scanner(System.in);
//		System.out.println("Mời bạn nhập vào số thứ 1:");
//		int num1 = sc.nextInt();
//		
//		System.out.println("Mời bạn nhập vào số thứ 2:");
//		int num2 = sc.nextInt();
//		
//		System.out.println("Mời bạn nhập vào số thứ 3:");
//		int num3 = sc.nextInt();
//		
//		System.out.println("3 số nguyên bạn vừa nhập là: " + num1 +", " + num2 +", " + num3);
		
//		Question 2: Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
		System.out.println("\n--------------INPUT FROM CONSOLE Question 2--------------");
//		System.out.println("Mời bạn nhập vào số thực thứ 1:");
//		float f1 = sc.nextFloat();
//		
//		System.out.println("Mời bạn nhập vào số thực thứ 2:");
//		float f2 = sc.nextFloat();
//		
//		System.out.println("2 số thực bạn vừa nhập là: " + f1 + ", " + f2);
		
//		Question 3: Viết lệnh cho phép người dùng nhập họ và tên
		System.out.println("\n--------------INPUT FROM CONSOLE Question 3--------------");
//		System.out.println("Mời bạn nhập vào họ, đệm(nếu có):");
//		String str1 = sc.nextLine();
//		
//		System.out.println("Mời bạn nhập vào tên:");
//		String str2 = sc.nextLine();
//		
//		System.out.println("Họ và tên của bạn là: "+ str1 + " " + str2);
		
//		Question 4: Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
		System.out.println("\n--------------INPUT FROM CONSOLE Question 4--------------");
//		System.out.println("Mời bạn nhập vào sinh nhật của bạn theo định dạng(dd-MM-yyyy)");
//		System.out.println("Mời bạn nhập vào năm sinh:");
//		int year = sc.nextInt();
//		System.out.println("Mời bạn nhập vào tháng sinh:");
//		int month = sc.nextInt();
//		System.out.println("Mời bạn nhập vào ngày sinh:");
//		int day = sc.nextInt();
//		
//		LocalDate birthDay = LocalDate.of(year, month, day);
//		System.out.println("Sinh nhật của bạn là: " + birthDay);
		
//		Question 5: 
		System.out.println("\n--------------INPUT FROM CONSOLE Question 5--------------");
//			Viết lệnh cho phép người dùng tạo account (viết thành method)
//			Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào 
//			chương trình sẽ chuyển thành Position.Dev, Position.Test, 
//			Position.ScrumMaster, Position.PM
//		createAccount();
//		Question 6: lệnh cho phép người dùng tạo department (viết thành method)
		System.out.println("\n--------------INPUT FROM CONSOLE Question 6--------------");
//		createDepartment();
		
//		Question 7:Nhập số chẵn từ console
		System.out.println("\n--------------INPUT FROM CONSOLE Question 7--------------");
		
//		while (true) {
//			System.out.println("Nhập vào 1 số chẵn");
//			int a = sc.nextInt();
//			if (a % 2 == 0) {
//				System.out.println("Số chắc vừa nhập là: " + a);
//				return;
//			} else {
//				System.out.println("Nhập sai, mời nhập lại");
//			}
//		}
//		Question 8:
		System.out.println("\n--------------INPUT FROM CONSOLE Question 8--------------");
//		while (true) {
//			System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
//			System.out.println("1. Tạo Account");
//			System.out.println("2. Tạo Department");
//			System.out.println("3. Exit");
//			int a = sc.nextInt();
//			switch (a) {
//			case 1:
//				createAccount();
//				break;
//			case 2:
//				createDepartment();
//				break;
//			case 3:
//		
//				return;
//			default:
//				System.out.println("Mời bạn nhập lại");
//				break;
//			}
//		}
//		Question 9:
		System.out.println("\n--------------INPUT FROM CONSOLE Question 9--------------");
//		addGroupToAccount();
		
		//Question 10:
		System.out.println("\n--------------INPUT FROM CONSOLE Question 10--------------");
//		while (true) {
//			System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
//			System.out.println("1. Tạo Account");
//			System.out.println("2. Tạo Department");
//			System.out.println("3. Thêm Group vào Account");
//			int a = sc.nextInt();
//			if (a == 1 || a == 2 || a == 3 ) {
//				switch (a) {
//				case 1:
//					createAccount();
//					break;
//				case 2:
//					createDepartment();
//					break;
//				case 3:
//					addGroupToAccount();
//					break;
//				}
//				System.out.println("Bạn có muốn tiếp tục không, "
//						+ "hãy chọn Menu, Chọn 0 để thoát chương trình!");
//						int out = sc.nextInt();
//						if (out == 0) {
//						System.out.println("Bye!!!");
//						return;
//						} 
//			} else {
//				System.out.println("Nhập lại: ");
//			}
//		}
		
//		Question 11
		System.out.println("\n--------------INPUT FROM CONSOLE Question 11--------------");
		while (true) {
		System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
		System.out.println("1. Tạo Account");
		System.out.println("2. Tạo Department");
		System.out.println("3. Thêm Group vào Account");
		System.out.println("4. Thêm Account vào Group ngẫu nhiên");
		int a = sc.nextInt();
		if (a == 1 || a == 2 || a == 3 || a == 4 ) {
			switch (a) {
			case 1:
				createAccount();
				break;
			case 2:
				createDepartment();
				break;
			case 3:
				addGroupToAccount();
				break;
			case 4:
				addAccountToRandomGr();
				break;
			}
			System.out.println("Bạn có muốn tiếp tục không, "
					+ "hãy chọn Menu, Chọn 0 để thoát chương trình!");
					int out = sc.nextInt();
					if (out == 0) {
					System.out.println("Bye!!!");
					return;
					} 
		} else {
			System.out.println("Nhập lại: ");
		}
	}	
		
	}

	private static void addAccountToRandomGr() {
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
		Group[] groupArray = {group1, group2, group3};
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Thêm Account vào Group ngẫu nhiên");
		System.out.println("Các Username của Account");
		for (int i = 0; i < accArray.length; i++) {
			System.out.println(accArray[i].username);
		}
		System.out.println("Nhập vào Username muốn thêm vào Group");
		String userInput = scanner.next();
		
		Random randomGr = new Random();
		int indexGroup = randomGr.nextInt(groupArray.length);
		
		int indexAccount = -1;
		for (int i = 0; i < accArray.length; i++) {
			if (accArray[i].username.equals(userInput)) {
				indexAccount = i;
			}
		}
		if (indexAccount < 0) {
			System.out.println("Bạn đã nhập sai Username của Account, vui lòng thử lại");
		} else {
			for (int i = 0; i < accArray.length; i++) {
				if (accArray[i].username.equals(userInput)) {
					Group[] grAdd = {groupArray[indexGroup]};
					accArray[i].groups = grAdd;
					System.out.println("Bạn vừa thêm Group: " + accArray[indexAccount].groups[0].name 
							+ " cho Account: " + accArray[indexAccount].username);
				}
			}
		}
	}

	private static void addGroupToAccount() {
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
				Group[] groupArray = {group1, group2, group3};
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Thêm Group vào Account");
		System.out.println("Các Username của Account");
		for (int i = 0; i < accArray.length; i++) {
			System.out.println(accArray[i].username);
		}
		System.out.println("Nhập vào Username muốn thêm group vào");
		String userInput = scanner.next();
		System.out.println("Chọn Group muốn thêm vào Account");
		for (int i = 0; i < groupArray.length; i++) {
			System.out.println(groupArray[i].name);
		}
		System.out.println("Nhập vào tên Group muốn thêm vào Account");
		String groupInput = scanner.next();
		int indexGroup = -1;
		for (int i = 0; i < groupArray.length; i++) {
			if (groupArray[i].name.equals(groupInput)) {
				indexGroup = i;
			}
		}
		int indexAccount = -1;
		for (int i = 0; i < accArray.length; i++) {
			if (accArray[i].username.equals(userInput)) {
				indexAccount = i;
			}
		}
		if (indexAccount < 0 || indexGroup < 0 ) {
			System.out.println("Bạn đã nhập sai Username Account hoặc Tên Group, mời kiểm tra lại!");
		} else {
			for (int i = 0; i < accArray.length; i++) {
				if (accArray[i].username.equals(userInput)) {
					Group[] groupAdd = {groupArray[indexGroup]};
					accArray[i].groups = groupAdd;
					System.out.println("Bạn vừa thêm Group: " + accArray[indexAccount].groups[0].name 
							+ " cho Account: " + accArray[indexAccount].username);
				}
				
			}
		}
		
		
	}

	private static void createDepartment() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập thông tin Department mới");
		Department newDept = new Department();
		System.out.println("Mời bạn nhập vào ID:");
		newDept.id = sc.nextInt();
		System.out.println("Mời bạn nhập vào tên Department: ");
		newDept.name = sc.next();
		
		System.out.println("Thông tin Department mới là:");
		System.out.println("ID: "+ newDept.id + "\nName: " + newDept.name);
	}

	private static void createAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào thông tin Account mới");
		Account acc = new Account();
		System.out.println("Mời bạn nhập vào ID:");
		acc.id = sc.nextInt();
		System.out.println("Mời bạn nhập vào Email:");
		acc.email = sc.next();
		System.out.println("Mời bạn nhập vào Username:");
		acc.username = sc.next();
		System.out.println("Mời bạn nhập vào Full name:");
		acc.fullname = sc.next();
		System.out.println("Mời bạn chọn vị trí cho Account từ 1 tới 4 tương ứng với (1.DEV, 2.TEST, 3.SCRUM MASTER, 4.PM)");
		int posName = sc.nextInt();
		switch (posName) {
		case 1:
			Position pos1 = new Position();
			pos1.name = PositionName.DEV;
			acc.position = pos1;
			break;
			
		case 2:
			Position pos2 = new Position();
			pos2.name = PositionName.TEST;
			acc.position = pos2;
			break;
			
		case 3:
			Position pos3 = new Position();
			pos3.name = PositionName.SCRUM_MASTER;
			acc.position = pos3;
			break;
			
		case 4:
			Position pos4 = new Position();
			pos4.name = PositionName.PM;
			acc.position = pos4;
			break;
		}
		System.out.println("Thông tin Account vừa tạo là: ");
		System.out.println("\nID: " + acc.id + "\nEmail: " + acc.email
				+ "\nUserName: " + acc.username + "\nFullname: " + acc.fullname
				+ "\nPosition: "+ acc.position.name);
	}
}
