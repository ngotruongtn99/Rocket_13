package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class DemoCRUD {

	public static void main(String[] args) {
		DepartmentRepository depRepository = new DepartmentRepository();
		Scanner scanner = new Scanner(System.in);
		int choose = menu();
		switch (choose) {
		case 1:
			List<Department> list =  depRepository.getAllDepartment();
			for (Department department : list) {
				System.out.println("ID " + department.getId() + ", Name " + department.getName());
			}
			break;
		case 2:
			System.out.println("Nhập vào ID:");
			int id = scanner.nextInt();
			boolean result = depRepository.isDepartmentExistsById((short) id);
			if (result != true) {
				System.out.println("Không có phòng ban trên hệ thống");
			}else {
				Department department = depRepository.getDepartmentById((short) id);
				System.out.println("ID " + department.getId() + ", Name " + department.getName());
			}
			break;
			
		case 3:
			System.out.println("Nhập vào tên phòng ban: ");
			String name = scanner.nextLine();
			boolean result1 = depRepository.isDepartmentExistsByName(name);
			if (result1 != true) {
				System.out.println("Không có phòng ban trên hệ thống");
			} else {
				Department department = depRepository.getDepartmentByName(name);
				System.out.println("ID " + department.getId() + ", Name " + department.getName());
			}
			break;
			
		case 4:
			System.out.println("Nhập vào tên phòng ban mới:");
			String newName = scanner.nextLine();
			boolean result2 = depRepository.isDepartmentExistsByName(newName);
			if (result2 != false) {
				System.out.println("Phòng ban đã tồn tại trên hệ thống");
			} else {
				Department department = new Department();
				department.setName(newName);
				depRepository.createDepartment(department);
				System.out.println("Tạo thành công !");
			}
			break;
		case 5:
			return;
		default:
			System.out.println("Chọn đúng số lên Menu !");
			break;
		}
	}

	private static int menu() {

		while (true) {
			System.out.println("CHương trình quản lý phòng ban..");
			System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
			System.out.println("1. Lấy danh sách tất cả các phòng ban trên hệ thống");
			System.out.println("2. Tìm phòng ban theo ID");
			System.out.println("3. Tìm phòng ban theo Name");
			System.out.println("4. Tạo mới 1 phòng");
			System.out.println("5. Thoát");
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				int i = sc.nextInt();
				if ((i == 1) || (i == 2) || (i == 3) || (i == 4)) {
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
