package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.entity.Position;
import com.vti.repository.PositionRepository;
import com.vti.ultis.ScannerUltis;

public class DemoPosition {

	public static void main(String[] args) {
		while (true) {
			System.out.println("Mời bạn chọn chức năng");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                               Choose please                              |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Danh sách tất cả các Position trên hệ thống");
			System.out.format(leftAlignFormat, "2. Tìm Position Theo ID");
			System.out.format(leftAlignFormat, "3. Tìm Position Theo Name");
			System.out.format(leftAlignFormat, "4. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			Scanner sc = new Scanner(System.in);
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				showAllPos();
				break;

			case 2:
				showPosById();
				break;

			case 3:
				showPosByName();
				break;
			case 4:
				return;
			default:
				System.out.println("Mời nhập đúng Menu ! ");
				break;
			}
		}
	}

	private static void showPosByName() {
		PositionRepository posRepository = new PositionRepository();
		System.out.println("Nhập Name muốn tìm");
		String name = ScannerUltis.inputString();
		boolean result = posRepository.isPositionExistsByName(name);
		if (result != true) {
			System.out.println("Không tồn tại Position trên Hệ thống ! ");
		}else {
			Position position = posRepository.getPositionByName(name);
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Position Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, position.getId(), position.getName());
			System.out.format("+--------+-----------------------+%n");
		}
	}

	private static void showPosById() {
		PositionRepository posRepository = new PositionRepository();
		System.out.println("Nhập ID muốn tìm");
		int id = ScannerUltis.inputIntPositive();
		boolean result = posRepository.isPositionExistsById((short) id);
		if (result != true) {
			System.out.println("Không tồn tại Position trên Hệ thống ! ");
		}else {
			Position position = posRepository.getPositionById((short) id);
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Position Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, position.getId(), position.getName());
			System.out.format("+--------+-----------------------+%n");
		}
		
	}

	private static void showAllPos() {
		PositionRepository posRepository = new PositionRepository();
		List<Position> list = posRepository.getListPosition();
		String leftAlignFormat = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | Position Name         |%n");
		System.out.format("+--------+-----------------------+%n");
		for (Position position : list) {
			System.out.format(leftAlignFormat, position.getId(), position.getName());
		}
		System.out.format("+--------+-----------------------+%n");
	}
}
