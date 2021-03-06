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
			System.out.println("Account kh??ng t????n ta??i");
		}
	}

	public void question3() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Nh????p va??o ID Account");
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
			System.out.println("Account kh??ng t????n ta??i");
		}
	}

	public void question4() throws ClassNotFoundException, SQLException {
		System.out.println("Nh????p va??o Username cu??a Account c????n ki????m tra");
		String username = ScannerUltis.inputString();
		boolean checkName = accDao.isAccountNameExists(username);
		if (checkName) {
			System.out.println("Username ??a?? co?? tr??n h???? th??ng");
		} else {
			System.out.println("Username ch??a co?? tr??n h???? th????ng");
		}
	}

	public void question5() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Account acc = new Account();
		System.out.println("Nh???p v??o Email: ");
		acc.setEmail(ScannerUltis.inputString());
		System.out.println("Nh???p v??o UserName: ");
		acc.setUsername(ScannerUltis.inputString());
		System.out.println("Nh???p v??o FullName: : ");
		acc.setFullName(ScannerUltis.inputString());
		System.out.println("H??y ch???n ph??ng nh??n vi??n: ");
		int depid = getDep();
		System.out.println("H??y ch???n Position nh??n vi??n: ");
		int posid = getPos();
		if (accDao.createAccount(acc, depid, posid)) {
			System.out.println("T???o th??nh c??ng: ");
			question1();
		} else {
			System.out.println("T???o kh??ng th??nh c??ng, h??y ki???m tra l???i");
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
			System.out.println("Ch???n Position theo ID:");
			int choosePos = ScannerUltis.inputIntPositive();
			;
			if (posDAO.getPosById(choosePos) != null) {
				return choosePos;
			} else {
				System.out.println("Kh??ng c?? Position n??y, h??y ch???n l???i: ");
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
			System.out.println("Ch???n ph??ng theo ID:");
			int chooseDep = ScannerUltis.inputIntPositive();

			if (depDAO.getDepartmentById(chooseDep) != null) {
				return chooseDep;
			} else {
				System.out.println("Kh??ng c?? ph??ng n??y, h??y ch???n l???i: ");
			}

		}
	}

	public void question6() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Nh????p va??o ID c????n update");
		int id = ScannerUltis.inputIntPositive();
		Account acc = accDao.getAccountById(id);
		if (acc != null) {
			while (true) {
				System.out.println("Cho??n tr??????ng ma?? ba??n mu????n Update:");
				System.out.println("1.Email, 2.UserName, 3.FullName, 4.Department, 5.Position, 6.Exit ");
				int choose = ScannerUltis.inputIntPositive();
				switch (choose) {
				case 1:
					System.out.println("Nh????p va??o Email m????i: ");
					String email = ScannerUltis.inputString();
					if (accDao.isAccountEmailExists(email)) {
						System.out.println("Email ??a?? t????n ta??i, xin th???? la??i");
					} else {
						if (accDao.updateAccountEmail(id, email)) {
							System.out.println("Update tha??nh c??ng");
							question1();
						} else {
							System.out.println("??a?? co?? l????i xa??y ra");
						}
					}
					break;

				case 2:
					System.out.println("Nh????p va??o Username m????i: ");
					String username = ScannerUltis.inputString();

					if (accDao.isAccountNameExists(username)) {
						System.out.println("Username ??a?? t????n ta??i, xin th???? la??i");
					} else {
						if (accDao.updateAccountUserName(id, username)) {
							System.out.println("Update tha??nh c??ng");
							question1();
						} else {
							System.out.println("??a?? co?? l????i xa??y ra");
						}
					}

					break;

				case 3:
					System.out.println("Nh????p va??o Fullname m????i: ");
					String fullname = ScannerUltis.inputString();
					if (accDao.updateAccountFullname(id, fullname)) {
						System.out.println("Update tha??nh c??ng");
						question1();
					} else {
						System.out.println("??a?? co?? l????i xa??y ra");
					}
					break;

				case 4:
					System.out.println("Nh????p va??o ID cu??a Department m????i: ");

					int idDep = getDep();
					if (accDao.updateAccountDep(id, idDep)) {
						System.out.println("Update tha??nh c??ng");
						question1();
					} else {
						System.out.println("??a?? co?? l????i xa??y ra");
					}
					break;

				case 5:
					System.out.println("Nh????p va??o ID cu??a Department m????i: ");

					int idPos = getPos();
					if (accDao.updateAccountPos(id, idPos)) {
						System.out.println("Update tha??nh c??ng");
						question1();
					} else {
						System.out.println("??a?? co?? l????i xa??y ra");
					}
					break;

				case 6:
					return;

				default:
					System.out.println("Nh????p la??i !");
					break;
				}
			}

		} else {
			System.out.println("Kh??ng t????n ta??i Account tr??n h???? th????ng");
		}
	}

	public void question7() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Nh????p va??o ID cu??a Account mu????n xo??a");
		int id = ScannerUltis.inputIntPositive();
		Account acc = accDao.getAccountById(id);
		if (acc != null) {
			accDao.delAccount(id);
			System.out.println("Xo??a tha??nh c??ng");
			question1();
		} else {
			System.out.println("Kh??ng t????n ta??i Account tr??n h???? th????ng");
		}

	}
}
