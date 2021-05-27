package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Ex6.VietnamesePhone;
import com.vti.entity.Ex6.Q2.Employee;
import com.vti.entity.Ex6.Q2.Manager;
import com.vti.entity.Ex6.Q2.User;
import com.vti.entity.Ex6.Q2.Waiter;

public class Exercise6 {
	Scanner sc;
	private ArrayList<User> users;
	
	public Exercise6() {
		sc = new Scanner(System.in);
		users = new ArrayList<User>();
	}
	public void DemoAbstract() {
		VietnamesePhone vnPhone = new VietnamesePhone();
		while (true) {
			System.out.println("*----------------------------MENU----------------------------*");
			System.out.println("|==     1) Insert Contact                                  ==|");
			System.out.println("|==     2) Remove Contact                                  ==|");
			System.out.println("|==     3) Update Contact                                  ==|");
			System.out.println("|==     4) Search Contact                                  ==|");
			System.out.println("|==     5) Thoát khỏi chương trình                         ==|");
			System.out.println("*------------------------------------------------------------*");
			
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				System.out.println("Nhập vào tên Contact muốn thêm:");
				String name = sc.next();
				System.out.println("Nhập số điện thoại: ");
				String phone = sc.next();
				vnPhone.insertContact(name, phone);
				vnPhone.printContact();
				break;
			case 2:
				System.out.println("Nhập tên Contact muốn xóa");
				String name1 = sc.next();
				vnPhone.removeContact(name1);
				vnPhone.printContact();
				break;
			case 3:
				System.out.println("Nhập vào tên Contact muốn update");
				String name2 = sc.next();
				System.out.println("Nhập vào số điện thoại mới");
				String newPhone = sc.next();
				vnPhone.updateContact(name2, newPhone);
				vnPhone.printContact();
				break;
				
			case 4:
				System.out.println("Nhập vào tên Contact muốn tìm");
				String name3 = sc.next();
				vnPhone.searchContact(name3);
				break;
			case 5:
				return;
			default:
				System.out.println("Mời chọn lại đúng Menu");
				break;
			}
		}
	}

	public void Question2_3() {
		while (true) {
			System.out.println("*----------------------------------MENU--------------------------------*");
			System.out.println("|==     1) Thêm vào Employee                                         ==|");
			System.out.println("|==     2) Thêm vào Manager                                          ==|");
			System.out.println("|==     3) Thêm vào Waiter                                           ==|");
			System.out.println("|==     4) Hiển thị thông tin User                                   ==|");
			System.out.println("|==     5) Thoát khỏi chương trình                                   ==|");
			System.out.println("*----------------------------------------------------------------------*");
			
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				System.out.println("Nhập vào tên Employee: ");
				String emNameInput = sc.next();
				System.out.println("Nhập vào SalaryRatio: ");
				Double emSalaryRatioInput = sc.nextDouble();
				Employee newEm = new Employee(emNameInput, emSalaryRatioInput);
				newEm.displayInfor();
				users.add(newEm);
				break;
				
			case 2:
				System.out.println("Nhập vào tên Manager: ");
				String managerNameInput = sc.next();
				System.out.println("Nhập vào SalaryRatio: ");
				Double managerSalaryRatioInput = sc.nextDouble();
				Manager newManager = new Manager(managerNameInput, managerSalaryRatioInput);
				newManager.displayInfor();
				users.add(newManager);
				break;
				
			case 3:
				System.out.println("Nhập vào tên Waiter: ");
				String waiterNameInput = sc.next();
				System.out.println("Nhập vào SalaryRatio: ");
				Double waiterSalaryRatioInput = sc.nextDouble();
				Waiter newWaiter = new Waiter(waiterNameInput, waiterSalaryRatioInput);
				newWaiter.displayInfor();
				users.add(newWaiter);
				break;
				
			case 4:
				displayInfor();

			default:
				break;
			}
	}
}
	private void displayInfor() {
		String leftAlignFormat = "| %-17s";
		String midtAlignFormat = "| %-16s ";
		String right1AlignFormat = "| %-15s ";
		String rightAlignFormat = "| %-17s| %n";
		
		System.out.format("+--------------------------------------------------------------------------+%n");
		System.out.format("|                               USERS                                      |%n");
		System.out.format("+--------------------------------------------------------------------------+%n");
		System.out.format(leftAlignFormat, "Tên người dùng");
		System.out.format(midtAlignFormat, "Vị trí");
		System.out.format(right1AlignFormat, "Ratio Salary");
		System.out.format(rightAlignFormat, "Tiền lương");
		System.out.format("+--------------------------------------------------------------------------+%n");
		for (User user : users) {
			System.out.format(leftAlignFormat, user.getName());
			
			if (user instanceof Employee) {
				System.out.format(midtAlignFormat, "Employee");
			} else if(user instanceof Manager) {
				System.out.format(midtAlignFormat, "Manager");
			} else {
				System.out.format(midtAlignFormat, "Waiter");
			}
			System.out.format(right1AlignFormat, user.getSalaryRatio());
			System.out.format(rightAlignFormat, user.calculatePay());
		}
		
		System.out.format("+--------------------------------------------------------------------------+%n");

	}
}

