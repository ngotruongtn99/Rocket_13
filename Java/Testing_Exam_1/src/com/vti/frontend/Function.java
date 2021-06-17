package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.User;
import com.vti.ultis.ScannerUltis;

public class Function {
	private UserController userController;
	
	public Function() throws FileNotFoundException, IOException {
		userController = new UserController();
	}
	public void loginUser() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập Email");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập Password");
		String password = ScannerUltis.inputPassword();
		if (userController.loginUser(email, password)) {
			System.out.println("Đăng nhập thành công");
			MenuUser();
		} else {
			System.out.println("Sai Email hoặc Password !");
			return;
		}
		
	}
	public void loginAdmin() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập Email");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập Password");
		String password = ScannerUltis.inputPassword();
		if (userController.loginAdmin(email, password)) {
			System.out.println("Đăng nhập thành công");
			MenuAdmin();
		} else {
			System.out.println("Sai Email hoặc Password !");
			return;
		}
		
	}
	public void MenuAdmin() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.format("+-----------------------------------------------------------+%n");
			System.out.format("|                            MENU                           |%n");
			System.out.format("+-----------------------------------------------------------+%n");
			String leftAlignFormat = "| %-59s|%n";
			System.out.format(leftAlignFormat,"1. Thông tin tất cả User");
			System.out.format(leftAlignFormat,"2. Thông tin User theo ID");
			System.out.format(leftAlignFormat,"3. Xóa User theo ID");
			System.out.format(leftAlignFormat,"4. Tạo User Employee mới");
			System.out.format(leftAlignFormat,"5. Exit");
			System.out.format("+-----------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				printUser();
				break;
			case 2:
				printUserById();
				break;
				
			case 3: 
				deleteUserById();
				break;
			case 4:
				createNewUser();
				break;
			case 5: 
				return;
			default:
				System.out.println("Mời chọn đúng MENU ");
				break;
			}
		}
	}
	private void createNewUser() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào Email của Employee");
		String email = ScannerUltis.inputEmail();
		if (userController.isEmailExists(email)) {
			System.out.println("Email đã tồn tại");
		}else {
			System.out.println("Nhập vào Fullname của Employee");
			String fullname = ScannerUltis.inputString();
			if (userController.createEmployee(email, fullname)) {
				System.out.println("Tạo Employee thành công");
				printUser();
			} else {
				System.out.println("Đã có lỗi xảy ra !!");
			}
		}
	}
	public void MenuUser() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.format("+-----------------------------------------------------------+%n");
			System.out.format("|                            MENU                           |%n");
			System.out.format("+-----------------------------------------------------------+%n");
			String leftAlignFormat = "|%-59s|%n";
			System.out.format(leftAlignFormat,"1. Thông tin tất cả User");
			System.out.format(leftAlignFormat,"2. Thông tin User theo ID");
			System.out.format(leftAlignFormat,"3. Xóa User theo ID");
			System.out.format(leftAlignFormat,"4. Exit");
			System.out.format("+-----------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				printUser();
				break;
			case 2:
				printUserById();
				break;
				
			case 3: 
				deleteUserById();
				break;
			default:
				System.out.println("Mời chọn đúng MENU ");
				break;
			}
		}
	}

	private void deleteUserById() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào ID muốn xóa");
		int id = ScannerUltis.inputIntPositive();
		User user = userController.getUserById(id);
		if (user != null) {
			if (userController.deleteUserById(id)) {
				System.out.println("Xóa thành công");
				printUser();
			} else {
				System.out.println("Đã có lỗi xảy ra !");
			}
		} else {
			System.out.println("Không tồn tại User trên Hệ thống");
		}
		
	}

	private void printUserById() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vài ID: ");
		int id = ScannerUltis.inputIntPositive();
		User user = userController.getUserById(id);
		if (user != null) {
			System.out.format("+--------------------------------------------------------------+%n");
			System.out.format("|                             USER                             |%n");
			System.out.format("|------+-----------------------+-------------------------------|%n");
			System.out.format("|  ID  |        FullName       |             Email             |%n");
			System.out.format("|------+-----------------------+-------------------------------|%n");
			String leftAlignFormat = "| %-4d | %-21s | %-30s| %n";
			System.out.format(leftAlignFormat, user.getId(), user.getFullname(), user.getEmail());
			System.out.format("+------+-----------------------+-------------------------------+%n");
		
		} else {
			System.out.println("Không tìm thấy User trên Hệ thống");
		}
		
	}

	private void printUser() throws ClassNotFoundException, SQLException {
		List<User> list = new ArrayList<User>();
		list = userController.getListUser();
		System.out.format("+--------------------------------------------------------------+%n");
		System.out.format("|                             USER                             |%n");
		System.out.format("|------+-----------------------+-------------------------------|%n");
		System.out.format("|  ID  |        FullName       |             Email             |%n");
		System.out.format("|------+-----------------------+-------------------------------|%n");
		String leftAlignFormat = "| %-4d | %-21s | %-30s| %n";
		for (User user : list) {
			System.out.format(leftAlignFormat, user.getId(), user.getFullname(), user.getEmail());
		}
		System.out.format("+------+-----------------------+-------------------------------+%n");
	
	}
}
