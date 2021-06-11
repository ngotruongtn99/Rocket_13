package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.presentationlayer.DepartmentController;
import com.vti.entity.Department;
import com.vti.ultis.ScannerUltis;

public class departmentFunction {
	private static DepartmentController departmentController;
	
	public departmentFunction() throws FileNotFoundException, IOException {
		departmentController = new DepartmentController();
	}
	public void menuDepartment() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		while (true) {
			System.out.println("+---------------------------------------------+");
			System.out.println("|+--------------------MENU-------------------+|");
			System.out.println("|+--          1)Xem danh sách Department   --+|");
			System.out.println("|+--          2)Tìm kiếm Department        --+|");
			System.out.println("|+--          3)Create Department          --+|");
			System.out.println("|+--          4)Update Department          --+|");
			System.out.println("|+--          5)Delete Department          --+|");
			System.out.println("|+--          6)Exit                       --+|");
			System.out.println("+---------------------------------------------+");
			System.out.println("Chọn chức năng");
			int choose = ScannerUltis.inputIntPositive();
			switch (choose) {
			case 1:
				getListDepartment();
				break;

			case 2:
				getDepartmentById();
				break;
				
			case 3:
				createDepartment();
				break;
				
			case 4:
				updateDepartmentByID();
				break;
				
			case 5:
				deleteDepartment();
				break;
				
			case 6:
				return;
				
			default:
				System.out.println("Mời chọn đúng MENU !");
				break;
			}
		}
	}
	private void deleteDepartment() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào ID muốn xóa");
		int id = ScannerUltis.inputIntPositive();
		Department department = departmentController.getDepartmentById(id);
		if (department != null) {
			if (departmentController.deleteDepartment(id)) {
				System.out.println("Xóa thành công");
				getListDepartment();
			} else {
				System.out.println("Đã có lỗi xảy ra");
			}
		} else {
			System.out.println("Không tồn tại Department trên hệ thống");
		}
	}
	private void updateDepartmentByID() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào ID muốn Update");
		int id = ScannerUltis.inputIntPositive();
		Department department = departmentController.getDepartmentById(id);
		if (department != null) {
			System.out.println("Nhập vào tên Department mới");
			String name = ScannerUltis.inputString();
			if (departmentController.updateDepartmentName(id, name)) {
				System.out.println("Tạo thành công");
				getListDepartment();
			} else {
				System.out.println("Đã có lỗi xảy ra");
			}
		} else {
			System.out.println("Không tồn tại Department trên Hệ thống");
		}
	}
	private void createDepartment() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào tên Department muốn tạo ");
		if (departmentController.createDepartment(ScannerUltis.inputString())) {
			System.out.println("Tạo thành công");
			getListDepartment();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}
	}
	private void getDepartmentById() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào ID cần tìm");
		int id = ScannerUltis.inputIntPositive();
		Department dep = departmentController.getDepartmentById(id);
		if (dep != null) {
			String leftAlignFormat = "| %-7d | %-28s |%n";
			System.out.format("+---------+------------------------------+%n");
			System.out.format("|    ID   |      DepartmentName          |%n");
			System.out.format("+---------+------------------------------+%n");
			
			System.out.format(leftAlignFormat, dep.getId(), dep.getName());

			System.out.format("+---------+------------------------------+%n");
		} else {
			System.out.println("Không tồn tại Department trên hệ thống");
		}
		

	}
	private void getListDepartment() throws ClassNotFoundException, SQLException {
		List<Department> list = departmentController.getDepartments();
		String leftAlignFormat = "| %-7d | %-28s |%n";
		System.out.format("+---------+------------------------------+%n");
		System.out.format("|    ID   |      DepartmentName          |%n");
		System.out.format("+---------+------------------------------+%n");
		for (Department department : list) {
			System.out.format(leftAlignFormat, department.getId(), department.getName());
		}
		System.out.format("+---------+------------------------------+%n");
	}
}
