package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;
import com.vti.ultis.ScannerUltis;

public class DemoDepartment {

	public static void main(String[] args) {
		while (true) {
			System.out.println("Mời bạn chọn chức năng");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                               Choose please                              |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Danh sách tất cả các Department trên hệ thống");
			System.out.format(leftAlignFormat, "2. Tìm Department Theo ID");
			System.out.format(leftAlignFormat, "3. Tạo mới Department");
			System.out.format(leftAlignFormat, "4. Xóa Department");
			System.out.format(leftAlignFormat, "5. Update Department");
			System.out.format(leftAlignFormat, "6. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			Scanner sc = new Scanner(System.in);
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				showAllDep();
				break;

			case 2:
				showAllDepById();
				break;
				
			case 3:
				createDepartment();
				break;
			case 4:
				deleteDepartment();
				break;
				
			case 5:
				updateDepartment();
				break;
				
			case 6:
				return;
			default:
				System.out.println("Mời nhập đúng Menu ! ");
				break;
			}
		}
	}

	private static void updateDepartment() {
		while (true) {
			DepartmentRepository depRepository = new DepartmentRepository();
			System.out.println("Nhập ID muốn Update");
			int id = ScannerUltis.inputIntPositive();
			Department department = depRepository.getDepartmentById((short) id);
			if (department == null) {
				System.out.println("Không tồn tại phòng ban trên hệ thống !");
				System.out.println("Mời nhập lại !");
				break;
			}
			System.out.println("Nhập vào tên mới");
			String name = ScannerUltis.inputString();
			boolean result = depRepository.isDepartmentExistsByName(name);
			if (result != false) {
				System.out.println("Đã tồn tại tên trên Hệ thống !");
				System.out.println("Mời thử lại");
				break;
			}
			department.setName(name);
			depRepository.updateDepartment(department);
			System.out.println("Update thành công");
			return;
		}
		
	}

	private static void createDepartment() {
		DepartmentRepository depRepository = new DepartmentRepository();
		System.out.println("Nhập tên của Department");
		String name = ScannerUltis.inputString();
		boolean result = depRepository.isDepartmentExistsByName(name);
		if (result != false) {
			System.out.println("Tên đã tồn tại !");
		} else {
			Department department = new Department();
			department.setName(name);
			depRepository.createDepartment(department);
			System.out.println("Tạo thành công !");
		}
	}

	private static void deleteDepartment() {
		DepartmentRepository depRepository = new DepartmentRepository();
		System.out.println("Nhập ID muốn xóa");
		int id = ScannerUltis.inputIntPositive();
		boolean result = depRepository.isDepartmentExistsById((short) id);
		if (result != true) {
			System.out.println("Không tồn tại Department trên HT");
		} else {
			depRepository.deleteDepartment((short) id);
			System.out.println("Xóa thành công");
			showAllDep();
		}
	}

	private static void showAllDepById() {
		DepartmentRepository depRepository = new DepartmentRepository();
		System.out.println("Nhập ID Department");
		int id = ScannerUltis.inputIntPositive();
		boolean result = depRepository.isDepartmentExistsById((short) id);
		if (result != true) {
			System.out.println("Không tồn tại Department !");
		} else {
			Department department = depRepository.getDepartmentById((short) id);
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Depament Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, department.getId(), department.getName());
			System.out.format("+--------+-----------------------+%n");
		}
	}

	private static void showAllDep() {
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
	}

}
