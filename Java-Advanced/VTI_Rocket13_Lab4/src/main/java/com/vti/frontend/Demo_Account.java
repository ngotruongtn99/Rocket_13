package com.vti.frontend;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.repository.AccountRepository;
import com.vti.repository.DepartmentRepository;
import com.vti.repository.PositionRepository;
import com.vti.ultis.ScannerUltis;

public class Demo_Account {

	public static void main(String[] args) {
		AccountRepository accRepository = new AccountRepository();
		ScannerUltis sc = new ScannerUltis();
		while (true) {
			int choose = menu();
			switch (choose) {
			case 1:
				showAllAccount();
				break;

			case 2:
				System.out.println("Mời bạn nhập vào ID");
				int id = sc.inputInt();
				boolean result = accRepository.isAccountExistsById((short) id);
				if (result != true) {
					System.out.println("Account không tồn tại trên hệ thống !");
				}else {
					Account account = accRepository.getAccountById((short) id);
					String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-14s | %-17s | %n";
					System.out.format(
							"+----+-----------------------+-----------------+-----------------------+----------------+----------------+-----------------------+%n");
					System.out.format(
							"|ID  | Email                 | Username        |   FullName            | Department     | Possition      | Create Date           |%n");
					System.out.format(
							"+----+-----------------------+-----------------+-----------------------+----------------+----------------+-----------------------+%n");
					System.out.format(leftAlignFormat, account.getId(), account.getEmail(), account.getUsername(),
							account.getFullname(), account.getDepartment().getName(), account.getPosition().getName(),
							account.getCreateDate());
					System.out.format(
							"+----+-----------------------+-----------------+-----------------------+----------------+----------------+-----------------------+%n");

				}
				
				break;

			case 3:
				createAccount();
				break;

			case 4:
				deleteAccount();
				break;

			case 5:
				updateAccount();
				break;

			case 6:
				return;

			default:
				System.out.println("Nhập đúng Menu !!");
				break;
			}
		}
	}

	private static void updateAccount() {
		while (true) {
			AccountRepository accRepository = new AccountRepository();
			ScannerUltis sc = new ScannerUltis();
			System.out.println("Nhập ID Account muốn Update:");
			int id = sc.inputIntPositive();
			boolean result = accRepository.isAccountExistsById((short) id);
			if (result != true) {
				System.out.println("Account không tồn tại trên hệ thống !");
				break;
			}
			System.out.println("Nhập Email");
			String newEmail = sc.inputEmail();
			boolean result1 = accRepository.isAccountExistsByEmail(newEmail);
			if (result1 != false) {
				System.out.println("Email đã tồn tại trên hệ thống !");
				break;
			}
			System.out.println("Nhập Username");
			String newUsername = sc.inputString();
			boolean result2 = accRepository.isAccountExistsByName(newUsername);
			if (result2 != false) {
				System.out.println("Username đã tồn tại trên hệ thống !");
				break;
			}
			System.out.println("Nhập Fullname");
			String newFullname = sc.inputString();
			Department department = getDep();
			Position position = getPos();
			Account account = accRepository.getAccountById((short) id);
			account.setEmail(newEmail);
			account.setUsername(newUsername);
			account.setFullname(newFullname);
			account.setDepartment(department);
			account.setPosition(position);
			accRepository.updateAccount(account);
			System.out.println("Update Account " + id + " thành công");
			showAllAccount();
			return;
		}
		
	}

	private static void createAccount() {
		while (true) {
			AccountRepository accRepository = new AccountRepository();
			ScannerUltis sc = new ScannerUltis();
			System.out.println("Nhập Email:");
			String newEmail = sc.inputEmail();
			boolean result = accRepository.isAccountExistsByEmail(newEmail);
			if (result != false) {
				System.out.println("Đã tồn tại Email trên hệ thống !!");
				break;
			}
			System.out.println("Nhập vào Username:");
			String newUsername = sc.inputString();
			boolean result1 = accRepository.isAccountExistsByName(newUsername);
			if (result1 != false) {
				System.out.println("Đã tồn tại Username trên hệ thống !!");
				break;
			}
			System.out.println("Nhập vào Fullname");
			String newFullname = sc.inputString();
			Department department = getDep();
			Position position = getPos();
			Account account2 = new Account();
			account2.setEmail(newEmail);
			account2.setFullname(newFullname);
			account2.setUsername(newUsername);
			account2.setDepartment(department);
			account2.setPosition(position);
			accRepository.createAccount(account2);
			System.out.println("Tạo thành công !");
			showAllAccount();
			return;
		}
	}

	private static void deleteAccount() {
		while (true) {
			AccountRepository accRepository = new AccountRepository();
			ScannerUltis sc = new ScannerUltis();
			System.out.println("Nhập vào ID muốn xóa");
			int idDel = sc.inputIntPositive();
			boolean result = accRepository.isAccountExistsById((short) idDel);
			if (result != false) {
				accRepository.deleteAccount((short) idDel);
				showAllAccount();
				return;
			} else {
				System.out.println("Mời nhập lại");
				break;
			}
		}
	}

	private static Position getPos() {
		while (true) {
			ScannerUltis sc = new ScannerUltis();
			PositionRepository posRepository = new PositionRepository();
			List<Position> listPos = posRepository.getListPosition();
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Position Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Position position : listPos) {
				System.out.format(leftAlignFormat, position.getId(), position.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chọn Position theo ID");
			int idPos = sc.inputIntPositive();
			Position position = posRepository.getPositionById((short) idPos);
			if (position != null) {
				return position;
			} else {
				System.out.println("Không có Position trên hệ thông, mời nhập lại !");
			}

		}

	}

	private static Department getDep() {
		while (true) {
			ScannerUltis sc = new ScannerUltis();
			DepartmentRepository depRepository = new DepartmentRepository();
			List<Department> listDep = depRepository.getListDepartment();
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Depament Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Department department : listDep) {
				System.out.format(leftAlignFormat, department.getId(), department.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chọn Department theo ID	");
			int idDep = sc.inputIntPositive();
			Department dep = depRepository.getDepartmentById((short) idDep);
			if (dep != null) {
				return dep;
			} else {
				System.out.println("Không tồn tại phòng ban trên hệ thống");
				System.out.println("Mời chọn lại");
			}

		}
	}

	private static void showAllAccount() {
		AccountRepository accountRepository = new AccountRepository();
		List<Account> listAccounts = accountRepository.getAllAccount();
		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-14s | %-17s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+-----------------------+%n");
		System.out.format(
				"|ID  | Email                 | Username        |   FullName            | Department     | Possition      | Create Date           |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+-----------------------+%n");

		for (Account acc : listAccounts) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullname(),
					acc.getDepartment().getName(), acc.getPosition().getName(), acc.getCreateDate());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+-----------------------+%n");
	}

	private static int menu() {
		while (true) {
			System.out.println("Mời bạn chọn chức năng");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                               Choose please                              |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Danh sách tất cả các Account trên hệ thống");
			System.out.format(leftAlignFormat, "2. Tìm Account Theo ID");
			System.out.format(leftAlignFormat, "3. Tạo mới Account");
			System.out.format(leftAlignFormat, "4. Xóa Account");
			System.out.format(leftAlignFormat, "5. Update Account");
			System.out.format(leftAlignFormat, "6. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				int i = sc.nextInt();
				if ((i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 5) || (i == 6)) {
					return i;
				} else {
					System.out.println("Nhập lại");
				}
			} else {
				System.out.println("Nhập lại");
			}
		}
	}
}
