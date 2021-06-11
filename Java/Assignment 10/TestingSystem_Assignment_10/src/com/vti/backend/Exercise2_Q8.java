package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.DepartmentRepository;
import com.vti.backend.datalayer.PositionRepository;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.ultis.ScannerUltis;

public class Exercise2_Q8 {
	private AccountRepository accDao;

	public Exercise2_Q8() throws FileNotFoundException, IOException {
		accDao = new AccountRepository();
	}

	public void question1() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<Account> listAcc1 = accDao.getListAccount();
		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %-16s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
		System.out.format(
				"|ID  | Email                 | Username        |   FullName            | Department     | Position         | Create Date      |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

		for (Account acc : listAcc1) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullName(),
					acc.getDepartment(), acc.getPosition(), acc.getCreateDate());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
	}

	public void question2() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Account acc = accDao.getAccountById(5);
		if (acc != null) {
			String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %-16s | %n";
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
			System.out.format(
					"|ID  | Email                 | Username        |   FullName            | Department     | Position         | Create Date      |%n");
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullName(),
					acc.getDepartment(), acc.getPosition(), acc.getCreateDate());

			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

		} else {
			System.out.println("Account không tồn tại");
		}
	}

	public void question3() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Nhập vào ID Account");
		int id = ScannerUltis.inputIntPositive();
		Account acc = accDao.getAccountById(id);
		if (acc != null) {
			String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %-16s | %n";
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
			System.out.format(
					"|ID  | Email                 | Username        |   FullName            | Department     | Position         | Create Date      |%n");
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullName(),
					acc.getDepartment(), acc.getPosition(), acc.getCreateDate());

			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

		} else {
			System.out.println("Account không tồn tại");
		}
	}

	public void question4() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào Username của Account cần kiểm tra");
		String username = ScannerUltis.inputString();
		boolean checkName = accDao.isAccountNameExists(username);
		if (checkName) {
			System.out.println("Username đã có trên hệ thông");
		} else {
			System.out.println("Username chưa có trên hệ thống");
		}
	}

	public void question5() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Account acc = new Account();
		System.out.println("Nhập vào Email: ");
		acc.setEmail(ScannerUltis.inputString());
		System.out.println("Nhập vào UserName: ");
		acc.setUsername(ScannerUltis.inputString());
		System.out.println("Nhập vào FullName: : ");
		acc.setFullName(ScannerUltis.inputString());
		System.out.println("Hãy chọn phòng nhân viên: ");
		int depid = getDep();
		System.out.println("Hãy chọn Position nhân viên: ");
		int posid = getPos();
		if (accDao.createAccount(acc, depid, posid)) {
			System.out.println("Tạo thành công: ");
			question1();
		} else {
			System.out.println("Tạo không thành công, hãy kiểm tra lại");
		}

	}

	private int getPos() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			PositionRepository posDAO = new PositionRepository();
			List<Position> listpos = posDAO.getListPosition();
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Position Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Position position : listpos) {
				System.out.format(leftAlignFormat, position.getId(), position.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chọn Position theo ID:");
			int choosePos = ScannerUltis.inputIntPositive();
			;
			if (posDAO.getPosById(choosePos) != null) {
				return choosePos;
			} else {
				System.out.println("Không có Position này, hãy chọn lại: ");
			}
		}
	}

	private int getDep() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			DepartmentRepository depDAO = new DepartmentRepository();
			List<Department> listDep = depDAO.getDepartments();
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Depament Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Department department : listDep) {
				System.out.format(leftAlignFormat, department.getId(), department.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chọn phòng theo ID:");
			int chooseDep = ScannerUltis.inputIntPositive();

			if (depDAO.getDepartmentById(chooseDep) != null) {
				return chooseDep;
			} else {
				System.out.println("Không có phòng này, hãy chọn lại: ");
			}

		}
	}

	public void question6() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Nhập vào ID cần update");
		int id = ScannerUltis.inputIntPositive();
		Account acc = accDao.getAccountById(id);
		if (acc != null) {
			while (true) {
				System.out.println("Chọn trường mà bạn muốn Update:");
				System.out.println("1.Email, 2.UserName, 3.FullName, 4.Department, 5.Position, 6.Exit ");
				int choose = ScannerUltis.inputIntPositive();
				switch (choose) {
				case 1:
					System.out.println("Nhập vào Email mới: ");
					String email = ScannerUltis.inputString();
					if (accDao.isAccountEmailExists(email)) {
						System.out.println("Email đã tồn tại, xin thử lại");
					} else {
						if (accDao.updateAccountEmail(id, email)) {
							System.out.println("Update thành công");
							question1();
						} else {
							System.out.println("Đã có lỗi xảy ra");
						}
					}
					break;

				case 2:
					System.out.println("Nhập vào Username mới: ");
					String username = ScannerUltis.inputString();

					if (accDao.isAccountNameExists(username)) {
						System.out.println("Username đã tồn tại, xin thử lại");
					} else {
						if (accDao.updateAccountUserName(id, username)) {
							System.out.println("Update thành công");
							question1();
						} else {
							System.out.println("Đã có lỗi xảy ra");
						}
					}

					break;

				case 3:
					System.out.println("Nhập vào Fullname mới: ");
					String fullname = ScannerUltis.inputString();
					if (accDao.updateAccountFullname(id, fullname)) {
						System.out.println("Update thành công");
						question1();
					} else {
						System.out.println("Đã có lỗi xảy ra");
					}
					break;

				case 4:
					System.out.println("Nhập vào ID của Department mới: ");

					int idDep = getDep();
					if (accDao.updateAccountDep(id, idDep)) {
						System.out.println("Update thành công");
						question1();
					} else {
						System.out.println("Đã có lỗi xảy ra");
					}
					break;

				case 5:
					System.out.println("Nhập vào ID của Department mới: ");

					int idPos = getPos();
					if (accDao.updateAccountPos(id, idPos)) {
						System.out.println("Update thành công");
						question1();
					} else {
						System.out.println("Đã có lỗi xảy ra");
					}
					break;

				case 6:
					return;

				default:
					System.out.println("Nhập lại !");
					break;
				}
			}

		} else {
			System.out.println("Không tồn tại Account trên hệ thống");
		}
	}

	public void question7() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Nhập vào ID của Account muốn xóa");
		int id = ScannerUltis.inputIntPositive();
		Account acc = accDao.getAccountById(id);
		if (acc != null) {
			accDao.delAccount(id);
			System.out.println("Xóa thành công");
			question1();
		} else {
			System.out.println("Không tồn tại Account trên hệ thống");
		}

	}
}
