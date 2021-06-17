package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;
import com.vti.ultis.ScannerUltis;

public class accountFunction {
	private AccountController accController;
	
	public accountFunction() throws FileNotFoundException, IOException {
		accController = new AccountController();
	}
	public boolean islogin() throws ClassNotFoundException, SQLException{
		System.out.println("Nhập vào Email: ");
		String email = ScannerUltis.inputEmail();
		System.out.println("Nhập vào Password: ");
		String password = ScannerUltis.inputPassword();
		return accController.loginAccount(email, password);
	}
	
	public void Menu() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			System.out.format("+---------------------------------------------------------+%n");
			System.out.format("|                           MENU                          |%n");
			System.out.format("+---------------------------------------------------------+%n");
			String leftAlignFormat = "| %-56s|%n";
			System.out.format(leftAlignFormat,"1. Tìm thành viên của Project theo ProjectID");
			System.out.format(leftAlignFormat,"2. Lấy ra tất cả các Manager của Project");
			System.out.format(leftAlignFormat,"3. Exit");
			System.out.format("+---------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				printAccountInProject();
				break;
			case 2:
				printManagerInProject();
				break;
				
			case 3: 
				return;
			default:
				System.out.println("Mời chọn đúng MENU ");
				break;
			}
		}
	}
	private void printManagerInProject() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<Account> list = new ArrayList<Account>();
		list = accController.accountManagerInProject();
		System.out.format("+--------------------------------------------------------------+%n");
		System.out.format("|                            ACCOUNT                           |%n");
		System.out.format("|------+-----------------------+-------------------------------|%n");
		System.out.format("|  ID  |        FullName       |             Email             |%n");
		System.out.format("|------+-----------------------+-------------------------------|%n");
		String leftAlignFormat = "| %-4d | %-21s | %-30s| %n";
		for (Account manager : list) {
			System.out.format(leftAlignFormat, manager.getId(), manager.getFullname(), manager.getEmail());
		}
		System.out.format("+------+-----------------------+-------------------------------+%n");
		
	}
	private void printAccountInProject() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<Account> list = new ArrayList<Account>();
		System.out.println("Nhập vào ProjectID");
		int projectID = ScannerUltis.inputIntPositive();
		list = accController.findAccountByProjectID(projectID);
		System.out.format("+--------------------------------------------------------------+%n");
		System.out.format("|                          ACCOUNT                             |%n");
		System.out.format("|------+-----------------------+-------------------------------|%n");
		System.out.format("|  ID  |        FullName       |             Email             |%n");
		System.out.format("|------+-----------------------+-------------------------------|%n");
		String leftAlignFormat = "| %-4d | %-21s | %-30s| %n";
		for (Account account : list) {
			System.out.format(leftAlignFormat, account.getId(), account.getFullname(), account.getEmail());
		}
		System.out.format("|------+-----------------------+-------------------------------|%n");
		
	}
}
