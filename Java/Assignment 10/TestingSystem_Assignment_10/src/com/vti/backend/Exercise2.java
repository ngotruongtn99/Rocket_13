package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.DepartmentRepository;
import com.vti.entity.Department;
import com.vti.ultis.ScannerUltis;

public class Exercise2 {
	private DepartmentRepository depDao;
	
	public Exercise2() throws FileNotFoundException, IOException {
		depDao = new DepartmentRepository();
	}
	
	public void Question1() throws ClassNotFoundException, SQLException {
		List<Department> listDep = depDao.getDepartments();
		String leftAlignFormat = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | Department Name       |%n");
		System.out.format("+--------+-----------------------+%n");

		for (Department department : listDep) {
			System.out.format(leftAlignFormat, department.getId(), department.getName());
		}
		System.out.format("+--------+-----------------------+%n");
	}
	
	public void Question2() throws ClassNotFoundException, SQLException {
		System.out.println("Thông tin Department có ID = 5: ");
		Department dep = depDao.getDepartmentById(5);
		if (dep != null	) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Department Name       |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, dep.getId(), dep.getName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Không tồn tại phòng này trên HT");
		}
	}
	
	public void Question3() throws ClassNotFoundException, SQLException {
		Department dep = depDao.getDepartmentById();
		if (dep != null	) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Department Name       |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, dep.getId(), dep.getName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Không tồn tại phòng này trên HT");
		}
	}
	
	public void Question4() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào tên phòng ban muốn kiểm tra: ");
		String name = ScannerUltis.inputString();
		Boolean dep = depDao.isDepartmentNameExists(name);
		if (dep) {
			System.out.println("Tên đã có trên hệ thống.");
			Question1();
		} else {
			System.out.println("Tên chưa có trên hệ thống.");
		}
	}
	
	public void Question5() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào tên của Department muốn tạo:");
		String name = ScannerUltis.inputString();
		boolean dep = depDao.createDepartment(name);
		if (dep) {
			System.out.println("Tạo thành công.");
			Question1();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}
	}
	
	public void Question6() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào ID của Department muốn Update ");
		int id = ScannerUltis.inputIntPositive();
		System.out.println("Nhập vào tên mới của Department: ");
		String newName = ScannerUltis.inputString();
		boolean idcheck = depDao.isDepartmentIdExists(id);
		if (idcheck) {
			boolean nameCheck = depDao.isDepartmentNameExists(newName);
			if (nameCheck) {
				System.out.println("Department Name is Exists");
			} else {
				if (depDao.updateDepartmentName(id, newName)) {
					System.out.println("Update Success ! ");
					Question1();
				} else {
					System.out.println("Đã xảy ra lỗi !");
				}
			}
		} else {
			System.out.println("Cannot find department which has id = " + id);
		}
	}
	
	public void Question7() throws ClassNotFoundException, SQLException {
		Question1();
		System.out.println("Nhập vào ID muốn xóa");
		int id = ScannerUltis.inputIntPositive();
		
		if (depDao.deleteDepartment(id) ) {
			System.out.println("Delete Success !");
			Question1();
		} else {
			System.out.println("Đã xảy ra lỗi");
		}
	}
	
	public void Question8() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("*----------------------------------MENU----------------------------------*");
			System.out.println("|==     1) Danh sách tất cả các Department                             ==|");
			System.out.println("|==     2) In thông tin Department có ID = 5                           ==|");
			System.out.println("|==     3) In thông tin Department theo ID                             ==|");
			System.out.println("|==     4) Kiểm tra sự tồn tại của Department                          ==|");
			System.out.println("|==     5) Tạo mới Department                                          ==|");
			System.out.println("|==     6) Cập nhập Department                                         ==|");
			System.out.println("|==     7) Xóa Department                                              ==|");
			System.out.println("|==     8) Thoát                                                       ==|");
			System.out.println("*------------------------------------------------------------------------*");
			int choose = ScannerUltis.inputInt();
			switch (choose) {
			case 1:
				Question1();
				break;

			case 2:
				Question2();
				break;

			case 3:
				Question3();
				break;

			case 4:
				Question4();
				break;

			case 5:
				Question5();
				break;
				
			case 6:
				Question6();
				break;
				
			case 7:
				Question7();
				break;
				
			case 8:
				return;
					
			default:
				System.out.println("Mời chọn đúng MENU");
				break;
			}
		}
	}
}
