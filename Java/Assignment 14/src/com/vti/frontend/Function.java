package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;
import com.vti.ultis.ScannerUltis;

public class Function {
	private AccountController accController;

	public Function() throws FileNotFoundException, IOException {
		accController = new AccountController();
	}

	public void loginUser() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào Email User");
		String email = ScannerUltis.inputEmail();
		System.out.println("Nhập vào Password User");
		String password = ScannerUltis.inputPassword();
		if (accController.loginUser(email, password)) {
			System.out.println("Đăng nhập thành công");
			MenuUser();
		} else {
			System.out.println("Sai Email hoặc Password");
		}
	}

	public void loginAdmin() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào Email Admin");
		String email = ScannerUltis.inputEmail();
		System.out.println("Nhập vào Password Admin");
		String password = ScannerUltis.inputPassword();
		if (accController.loginAdmin(email, password)) {
			System.out.println("Đăng nhập thành công");
			MenuAdmin();
		} else {
			System.out.println("Sai Email hoặc Password");
		}
	}

	public void MenuUser() throws ClassNotFoundException, SQLException {
		while (true) {
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                                 MENU                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Tìm thành viên của Project theo ID");
			System.out.format(leftAlignFormat, "2. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				printUserInProject();
				break;
			case 2:
				return;
			default:
				System.out.println("Mời chọn đúng MENU ");
				break;
			}
		}
	}

	public void MenuAdmin() throws ClassNotFoundException, SQLException {
		while (true) {
			String leftAlignFormat = "| %-73s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                                 MENU                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Tạo User mới");
			System.out.format(leftAlignFormat, "2. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				createNewUser();
				break;
			case 2:
				return;
			default:
				System.out.println("Mời chọn đúng MENU ");
				break;
			}
		}
	}

	private void createNewUser() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào Email");
		String email = ScannerUltis.inputEmail();
		if (accController.isEmailExists(email)) {
			System.out.println("Email đã tồn tại !");
		} else {
			System.out.println("Nhập vào Fullname");
			String fullname = ScannerUltis.inputString();
			if (accController.createAccount(email, fullname)) {
				System.out.println("Tạo Account thành công");
			} else {
				System.out.println("Đã có lỗi xảy ra");
			}
		}
	}

	private void printUserInProject() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào ProjectName");
		String name = ScannerUltis.inputString();
		List<Account> listAccounts = accController.listAccountInProject(name);
		if (listAccounts != null) {
			System.out.format("+--------------------------------------------------------------+%n");
			System.out.format("|                             USER                             |%n");
			System.out.format("|------+-----------------------+-------------------------------|%n");
			System.out.format("|  ID  |        FullName       |             Email             |%n");
			System.out.format("|------+-----------------------+-------------------------------|%n");
			String leftAlignFormat = "| %-4d | %-21s | %-30s| %n";
			for (Account acc : listAccounts) {
				System.out.format(leftAlignFormat, acc.getId(), acc.getFullname(), acc.getEmail());
			}
			System.out.format("+------+-----------------------+-------------------------------+%n");

		} else {
			System.out.println("Không có Project trên hệ thống");
		}
	}
}
