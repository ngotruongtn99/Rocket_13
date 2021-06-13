package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;
import com.vti.entity.Manager;
import com.vti.ultis.ScannerUltis;
import com.vti.ultis.jdbcUltis;

public class accountFunction {
	private jdbcUltis jdbc;
	private AccountController accController;
	
	public accountFunction() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
		accController = new AccountController();
	}
	public void Menu() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			System.out.format("+---------------------------------------------------------+%n");
			System.out.format("|                           MENU                          |%n");
			System.out.format("+---------------------------------------------------------+%n");
			String leftAlignFormat = "| %-56s|%n";
			System.out.format(leftAlignFormat,"1. Login");
			System.out.format(leftAlignFormat,"2. Tìm thành viên của Project theo ProjectID");
			System.out.format(leftAlignFormat,"3. Lấy ra tất cả các Manager của Project");
			System.out.format(leftAlignFormat,"4. Exit");
			System.out.format("+---------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				System.out.println("Nhập vào Email: ");
				String email = ScannerUltis.inputEmail();
				System.out.println("Nhập vào Password: ");
				String password = ScannerUltis.inputPassword();
				if (accController.loginAccount(email, password)) {
					System.out.println("Chào mừng " + email + " đã đến với hệ thống !!");
				} else {
					System.out.println("Sai Email hoặc Password !");
				}
				break;
			case 2:
				printAccountInProject();
				break;
			case 3:
				printManagerInProject();
				break;
				
			case 4: 
				return;
			default:
				System.out.println("Mời chọn đúng MENU ");
				break;
			}
		}
	}
	private void printManagerInProject() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<Manager> list = new ArrayList<Manager>();
		System.out.println("Nhập vào ProjectID");
		int projectID = ScannerUltis.inputIntPositive();
		list = accController.accountManagerInProject(projectID);
		System.out.format("+---------------------------------------------------------------------------------------+%n");
		System.out.format("|                                            ACCOUNT                                    |%n");
		System.out.format("|------+--------------+-------------------------------+------------------+--------------|%n");
		System.out.format("|  ID  |   FullName   |             Email             |     expInYear    |   Project    |%n");
		System.out.format("|------+--------------+-------------------------------+------------------+--------------|%n");
		String leftAlignFormat = "| %-4d | %-12s | %-29s| %-16s | %-12s| %n";
		for (Manager manager : list) {
			System.out.format(leftAlignFormat, manager.getId(), manager.getFullname(), manager.getEmail(), manager.getExpInYear(), manager.getProject().getName());
		}
		System.out.format("|------+--------------+-------------------------------+------------------+--------------|%n");
		
	}
	private void printAccountInProject() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<Account> list = new ArrayList<Account>();
		System.out.println("Nhập vào ProjectID");
		int projectID = ScannerUltis.inputIntPositive();
		list = accController.findAccountByProjectID(projectID);
		System.out.format("+---------------------------------------------------------------------------------------+%n");
		System.out.format("|                                            ACCOUNT                                    |%n");
		System.out.format("|------+--------------+-------------------------------+------------------+--------------|%n");
		System.out.format("|  ID  |   FullName   |             Email             |     Category     |   Project    |%n");
		System.out.format("|------+--------------+-------------------------------+------------------+--------------|%n");
		String leftAlignFormat = "| %-4d | %-12s | %-29s | %-16s | %-12s | %n";
		for (Account account : list) {
			System.out.format(leftAlignFormat, account.getId(), account.getFullname(), account.getEmail(), account.getPosition(), account.getProject().getName());
		}
		System.out.format("|------+--------------+-------------------------------+------------------+--------------|%n");
		
	}
}
