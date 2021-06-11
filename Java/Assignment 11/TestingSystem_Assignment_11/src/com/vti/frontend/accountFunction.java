package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.vti.backend.presentationlayer.AccountController;
import com.vti.backend.presentationlayer.DepartmentController;
import com.vti.backend.presentationlayer.PositionController;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.ultis.ScannerUltis;

public class accountFunction {
	private static AccountController accountController;

	public accountFunction() throws FileNotFoundException, IOException {
		accountController = new AccountController();
	}
	public void menuAccount() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		while (true) {
			System.out.println("+-----------------------------------------------------------------------------------------------------------------------------+");
			System.out.println("|+----------------------------------------------------------------MENU-------------------------------------------------------+|");
			System.out.println("|+---------------------------------------1)Xem danh sách Account               ----------------------------------------------+|");
			System.out.println("|+---------------------------------------2)Tìm kiếm Account                    ----------------------------------------------+|");
			System.out.println("|+---------------------------------------3)Create Account                      ----------------------------------------------+|");
			System.out.println("|+---------------------------------------4)Update Account                      ----------------------------------------------+|");
			System.out.println("|+---------------------------------------5)Delete Account                      ----------------------------------------------+|");
			System.out.println("|+---------------------------------------6)Exit                                ----------------------------------------------+|");
			System.out.println("+-----------------------------------------------------------------------------------------------------------------------------+");
			System.out.println("Chọn chức năng");
			int choose = ScannerUltis.inputIntPositive();
			switch (choose) {
			case 1:
				getListAccounts();
				break;

			case 2:
				getAccountById();
				break;
				
			case 3:
				createAccount();
				break;
				
			case 4:
				updateAccountByID();
				break;
				
			case 5:
				deleteAccount();
				break;
				
			case 6:
				return;
				
			default:
				System.out.println("Mời chọn đúng MENU !");
				break;
			}
		}
	}
	public static void getListAccounts()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		List<Account> list = accountController.getListAccounts();
		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %-16s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
		System.out.format(
				"|ID  | Email                 | Username        |   FullName            | Department     | Position         | Create Date      |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

		for (Account acc : list) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullname(),
					acc.getDepartment(), acc.getPosition(), acc.getCreateDate());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

	}

	public static void getAccountById()
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Nhập vào ID cần tìm: ");
		int id = ScannerUltis.inputInt();
		Account acc = accountController.getAccountById(id);
		if (acc != null) {
			String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %-16s | %n";
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
			System.out.format(
					"|ID  | Email                 | Username        |   FullName            | Department     | Position         | Create Date      |%n");
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullname(),
					acc.getDepartment(), acc.getPosition(), acc.getCreateDate());

			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

		} else {
			System.out.println("Không tồn tại account này trên HT");
		}
	}

	public static void isAccountNameExists() throws ClassNotFoundException, SQLException {
		System.out.println("Kiểm tra Username trên HT");
		System.out.println("Nhập vào Username");
		String nameCheck = ScannerUltis.inputString();
		if (accountController.isAccountNameExists(nameCheck)) {
			System.out.println("Tên này đã có người dùng");
		} else {
			System.out.println("Tên này chưa có người dùng");
		}
	}

	public static void createAccount() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

		System.out.println("Tạo Account mới");
		Account acc = new Account();
		System.out.println("Nhập vào Email");
		acc.setEmail(ScannerUltis.inputString());
		System.out.println("Nhập vào Username");
		acc.setUsername(ScannerUltis.inputString());
		System.out.println("Nhập vào Fullname");
		acc.setFullname(ScannerUltis.inputString());
		System.out.println("Nhập vào ID phòng ban");
		int idDep = getDep();
		System.out.println("Nhập vào ID vị trí");
		int idPos = getPos();
		if (accountController.createAccount(acc, idDep, idPos)) {
			System.out.println("Tạo thành công");
			getListAccounts();
			return;
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}
	}

	private static int getPos() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			PositionController posController = new PositionController();
			List<Position> list = posController.getListPosition();
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Position Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Position position : list) {
				System.out.format(leftAlignFormat, position.getId(), position.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			int choosePos = ScannerUltis.inputIntPositive();
			if (posController.getPositionById(choosePos) != null) {
				return choosePos;
			} else {
				System.out.println("Không có phòng này, hãy chọn lại:");
			}
		}
	}

	private static int getDep() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			DepartmentController departmentControler = new DepartmentController();
			List<Department> list = departmentControler.getDepartments();

			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Depament Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Department department : list) {
				System.out.format(leftAlignFormat, department.getId(), department.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			int chooseDep = ScannerUltis.inputIntPositive();
			if (departmentControler.getDepartmentById(chooseDep) != null) {
				return chooseDep;
			} else {
				System.out.println("Không có phòng này, hãy chọn lại:");
			}
		}
	}

	public static void updateAccountByID()
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {

		System.out.println("Nhập ID của Account muốn Update");
		int id = ScannerUltis.inputIntPositive();
		Account acc = accountController.getAccountById(id);
		if (acc == null) {
			System.out.println("Account không tồn tại !! Mời nhập lại ");
		} else {
			while (true) {
				System.out.println("-----------------------MENU--------------------------");
				System.out.println("----------------1) Update Email        --------------");
				System.out.println("----------------2) Update Username     --------------");
				System.out.println("----------------3) Update Fullname     --------------");
				System.out.println("----------------4) Update Department   --------------");
				System.out.println("----------------5) Update Position     --------------");
				System.out.println("----------------6) Exit                --------------");
				System.out.println("-----------------------------------------------------");
				System.out.println("Chọn chức năng");
				int choose = ScannerUltis.inputIntPositive();
				switch (choose) {
				case 1:
					System.out.println("Nhập vào Email mới: ");
					String email = ScannerUltis.inputString();
					if (accountController.isAccountEmailExists(email)) {
						System.out.println("Email đã tồn tại, mời thử lại");
					} else {
						if (accountController.updateAccountEmail(id, email)) {
							System.out.println("Update thành công");
							getListAccounts();
						} else {
							System.out.println("Đã có lỗi xảy ra");
						}
					}
					break;

				case 2:
					System.out.println("Nhập vào Username mới:");
					String username = ScannerUltis.inputString();
					if (accountController.isAccountNameExists(username)) {
						System.out.println("Username đã tồn tại, mời thử lại");
					} else {
						if (accountController.updateAccountUserName(id, username)) {
							System.out.println("Update thành công");
							getListAccounts();
						} else {
							System.out.println("Đã có lỗi xảy ra");
						}
					}
					break;

				case 3:
					System.out.println("Nhập vào Fullname");
					String fullname = ScannerUltis.inputString();
					if (accountController.updateAccountFullname(id, fullname)) {
						System.out.println("Update thành công");
						getListAccounts();
					} else {
						System.out.println("Đã có lỗi xảy ra");
					}
					break;

				case 4:
					System.out.println("Nhập vào DepartmentID");
					int idDep = getDep();
					if (accountController.updateAccountDep(id, idDep)) {
						System.out.println("Update thành công");
						getListAccounts();
					} else {
						System.out.println("Đã có lỗi xảy ra");
					}
					break;

				case 5:
					System.out.println("Nhập vào PositionID");
					int idPos = getPos();
					if (accountController.updateAccountPos(id, idPos)) {
						System.out.println("Update thành công");
					} else {
						System.out.println("Đã có lỗi xảy ra");
					}
					break;

				case 6:
					return;
				default:
					System.out.println("Vui lòng chọn đúng MENU !");
					break;
				}
			}
		}
	}

	public static void deleteAccount() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Nhập vào ID Account muốn xóa");
		int id = ScannerUltis.inputIntPositive();
		Account acc = accountController.getAccountById(id);
		if (acc != null) {
			if (accountController.delAccount(id)) {
				System.out.println("Delete thành công");
				getListAccounts();
			} else {
				System.out.println("Đã có lỗi xảy ra");
			}
		} else {
			System.out.println("Không tồn tại Account trên hệ thống");
		}
	}
}
