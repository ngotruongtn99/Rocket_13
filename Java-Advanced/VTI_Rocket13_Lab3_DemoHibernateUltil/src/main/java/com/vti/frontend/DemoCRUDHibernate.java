package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class DemoCRUDHibernate {
	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			int choose = menu();
			switch (choose) {
			case 1:
				showAllDepartment();
				break;
			case 2:
				System.out.println("Nhập vào ID của phòng ban");
				short id = sc.nextShort();
				showDepartmentById(id);
				break;

			case 3:
				System.out.println("Nhập vào tên phòng ban cần tìm kiếm");
				String nameDep = sc.nextLine();
				showDepartmentByName(nameDep);
				break;
			case 4:
				System.out.println("Tạo mới phòng ban");
				System.out.println("Nhập tên phòng cần tạo:");
				String nameDepCreate = sc.nextLine();
				Department dep = new Department();
				dep.setName(nameDepCreate);
				createDep(dep);
				showAllDepartment();
				break;
			case 5:
				return;
			default:
				System.out.println("Chọn lại !");
				break;
			}
		}
	}

	private static void createDep(Department dep) {
		DepartmentRepository depRepository = new DepartmentRepository();
		depRepository.createDepartment(dep);
	}

	private static void showDepartmentByName(String nameDep) {
		DepartmentRepository depRepository = new DepartmentRepository();
		Department depByName = depRepository.getDepartmentByName(nameDep);
		if (depByName == null) {
			System.out.println("Không có phòng ban này trên hệ thống");
		} else {
			String leftAlignFormat = "| %-5s | %-25s |%n";
			System.out.format("+-------+---------------------------+%n");
			System.out.format("| ID    | Name                      |%n");
			System.out.format("+-------+---------------------------+%n");
			System.out.format(leftAlignFormat, depByName.getId(), depByName.getName());
			System.out.format("+-------+---------------------------+%n");
		}

	}

	private static void showDepartmentById(short id) {
		DepartmentRepository depRepository = new DepartmentRepository();
		Department dep = depRepository.getDepartmentById(id);
		String leftAlignFormat = "| %-5s | %-25s |%n";
		System.out.format("+-------+---------------------------+%n");
		System.out.format("| ID    | Name                      |%n");
		System.out.format("+-------+---------------------------+%n");
		System.out.format(leftAlignFormat, dep.getId(), dep.getName());
		System.out.format("+-------+---------------------------+%n");
	}

	private static void showAllDepartment() {
		System.out.println("Danh sách các phòng ban trên hệ thống");
		DepartmentRepository depRepository = new DepartmentRepository();
		List<Department> list = depRepository.getAllDepartment();
		String leftAilgnFormat = "| %-18s| %-29s| %n";
		System.out.format("+-------------------+------------------------------+%n");
		System.out.format("|       ID          |      Name                    |%n");
		System.out.format("+-------------------+------------------------------+%n");
		for (Department department : list) {
			System.out.format(leftAilgnFormat, department.getId(), department.getName());
		}
		System.out.format("+------------------+-------------------------------+%n");

	}

	@SuppressWarnings("resource")
	private static int menu() {
		while (true) {
			System.out.println("Mời bạn chọn chức năng");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                               Choose please                              |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Lấy danh sách tất cả các phòng ban trên hệ thống");
			System.out.format(leftAlignFormat, "2. Tìm phòng ban theo ID");
			System.out.format(leftAlignFormat, "3. Tìm phòng ban theo Name");
			System.out.format(leftAlignFormat, "4. Tạo mới 1 phòng");
			System.out.format(leftAlignFormat, "5. Thoát");
			System.out.format("+--------------------------------------------------------------------------+%n");
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				int i = sc.nextInt();
				if ((i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 5)) {
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
