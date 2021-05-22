package com.vti.frontend;

import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class Demo3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choose;
		
		while (true) {
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Tạo Account");
			System.out.format(leftAlignFormat, "2. Tạo Department");
			System.out.format(leftAlignFormat, "3. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");

			choose = sc.nextInt();
			switch (choose) {
			case 1:

				createAccount();
				break;
			case 2:
				createDepartmet();
				break;

			case 3:

				return;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}
	}

	private static void createDepartmet() {
		// TODO Auto-generated method stub
		
	}

	private static void createAccount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Mời bạn vào thông tin Account cần tạo ");
		Account acc = new Account();
		System.out.println("Nhập vào ID: ");
		acc.id = scanner.nextInt();
		System.out.println("Nhập vào Email:");
		acc.email = scanner.next();
		System.out.println("Nhập vào Full name: ");
		acc.fullname = scanner.next();
		System.out.println("Nhập vào Username: ");
		acc.username = scanner.next();
		System.out.println("Nhập Position(Nhập vào các số từ 1 đến 4 tương ứng với vị trí: 1.Dev, 2.Test, 3.Scrum Master, 4.PM)");
		int posNum = scanner.nextInt();
		switch (posNum) {
		case 1:
			Position pos = new Position();
			pos.name = PositionName.DEV;
			acc.position = pos;
			break;

		case 2:
			Position pos11 = new Position();
			pos11.name = PositionName.TEST;
			acc.position = pos11;
			break;
			
		case 3:
			Position pos22 = new Position();
			pos22.name = PositionName.SCRUM_MASTER;
			acc.position = pos22;
			break;
			
		case 4:
			Position pos33 = new Position();
			pos33.name = PositionName.PM;
			acc.position = pos33;
			break;
		}
		System.out.println("Thông tin Account vừa tạo là: " + "\nID: " + acc.id + 
				"\nEmail: "+ acc.email + "\nFull Name: "+ acc.fullname + 
				"\nUsername: "+ acc.username + "\nPosition: " + acc.position.name);
	}
}
