package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;
import com.vti.ultis.ScannerUltis;

public class DemoHQL {

	public static void main(String[] args) {
		
		while (true) {
			System.out.println("Mời bạn chọn chức năng");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                               Choose please                              |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Danh sách tất cả các Account trên hệ thống");
			System.out.format(leftAlignFormat, "2. Tìm Account Theo ID");
			System.out.format(leftAlignFormat, "3. Lấy Fullname của Account");
			System.out.format(leftAlignFormat, "4. Danh sách các Account được tạo trong tháng hiện tại");
			System.out.format(leftAlignFormat, "5. Số lượng các Account được tạo trong mỗi tháng của năm hiện tại");
			System.out.format(leftAlignFormat, "6. Tháng có nhiều hơn 2 Account được tạo trong năm");
			System.out.format(leftAlignFormat, "7. Update Account");
			System.out.format(leftAlignFormat, "8. Delete Account");
			System.out.format(leftAlignFormat, "9. Phân trang với Hibernate");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				showAllAccount();
				break;
			case 2:
				showAllAccountById();
				break;
				
			case 3:
				showFullnameAccountById();
				break;
				
			case 4:
				showListAccountInCurrentMonth();
				break;
				
			case 5:
				showCountAccountEachMonthInYear();
				break;
				
			case 6:
				showMonthHaveMoreThan2AccountInYear();
				break;
				
			case 7:
				updateAccount();
				break;
				
			case 8:
				deleteAccount();
				break;
				
			case 9:
				hibernatePaging();
				break;
			default:
				break;
			}
		}
	}

	private static void hibernatePaging() {
		AccountRepository accRepository = new AccountRepository();
		List<Account> list = accRepository.get_AccountPaging();
		for (Account account : list) {
			System.out.println("ID: " + account.getId() + ", Email: "+ account.getEmail() + ", Username: "+ account.getUsername() + ", Fullname: "+ account.getFullname()
			+ ", Department: "+ account.getDepartment().getName() + ", Position: " + account.getPosition().getName());
		}
	}

	private static void deleteAccount() {
		AccountRepository accRepository = new AccountRepository();
		System.out.println("Nhập Email của Account muốn xóa");
		String email = ScannerUltis.inputEmail();
		Account acc = accRepository.getAccountByEmail(email);
		if (acc != null) {
			accRepository.deleteAccountByEmail(email);
			System.out.println("Xóa thành công");
			showAllAccount();
		} else {
			System.out.println("Không tồn tại Account trên Hệ thống");
		}
	}

	private static void updateAccount() {
		AccountRepository accRepository = new AccountRepository();
		System.out.println("Nhập vào ID muốn update");
		Scanner sc = new Scanner(System.in);
		short id = sc.nextShort();
		if (accRepository.getAccountById(id) == null) {
			System.out.println("Không tồn tại Account trên hệ thống ! ");
		} else {
			System.out.println("Nhập vào Username mới");
			String newUsername = sc.next();
			System.out.println("Nhập Email mới");
			String newEmail = sc.next();
			accRepository.updateEmailUsernammAccountById(newEmail, newUsername, id);
			showAllAccount();
		}
		
	}

	private static void showMonthHaveMoreThan2AccountInYear() {
		AccountRepository accRepository = new AccountRepository();
		List<Object[]> list = accRepository.getCountAccountInCurrentMonthInYearMoreThan2();
		for (Object[] objects : list) {
			System.out.println("Month: " + objects[0] + " COUNT: " + objects[1]);
		}		
	}

	private static void showCountAccountEachMonthInYear() {
		AccountRepository accRepository = new AccountRepository();
		List<Object[]> list = accRepository.getCountAccountInCurrentMonthInYear();
		for (Object[] objects : list) {
			System.out.println("Month: " + objects[0] + " COUNT: " + objects[1]);
		}
	}

	private static void showListAccountInCurrentMonth() {
		AccountRepository accRepository = new AccountRepository();
		List<Account> list = accRepository.getAccountInCurrentMonth();
		System.out.println("Account được tạo trong tháng hiện tại là: ");
		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-14s | %-17s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+-----------------------+%n");
		System.out.format(
				"|ID  | Email                 | Username        |   FullName            | Department     | Possition      | Create Date           |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+-----------------------+%n");
		for (Account acc : list) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullname(),
					acc.getDepartment().getName(), acc.getPosition().getName(), acc.getCreateDate());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+-----------------------+%n");
		
	}

	private static void showFullnameAccountById() {
		AccountRepository accRepository = new AccountRepository();
		System.out.println("Nhập vào ID của Account");
		Scanner sc = new Scanner(System.in);
		short id = sc.nextShort();
		String fullname = accRepository.getAccountByFullName(id);
		if (fullname == null) {
			System.out.println("Không tồn tại Account trên hệ thống !");
		} else {
			System.out.println("Account: " + id + " có Fullname là: " + fullname);
		}
	}

	private static void showAllAccountById() {
		AccountRepository accRepository = new AccountRepository();
		System.out.println("Nhập ID ");
		int id = ScannerUltis.inputIntPositive();
		Account acc = accRepository.getAccountById((short) id);
		if (acc == null) {
			System.out.println("Không tồn tại Account trên hệ thống !");
		} else {
			String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-14s | %-17s | %n";
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+----------------+-----------------------+%n");
			System.out.format(
					"|ID  | Email                 | Username        |   FullName            | Department     | Possition      | Create Date           |%n");
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+----------------+-----------------------+%n");
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullname(),
						acc.getDepartment().getName(), acc.getPosition().getName(), acc.getCreateDate());
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+----------------+-----------------------+%n");
		}
	}

	private static void showAllAccount() {
		AccountRepository accRepository = new AccountRepository();
		List<Account> list = accRepository.get_FROM();
		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-14s | %-17s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+-----------------------+%n");
		System.out.format(
				"|ID  | Email                 | Username        |   FullName            | Department     | Possition      | Create Date           |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+-----------------------+%n");

		for (Account acc : list) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullname(),
					acc.getDepartment().getName(), acc.getPosition().getName(), acc.getCreateDate());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+-----------------------+%n");
		
	}

}
