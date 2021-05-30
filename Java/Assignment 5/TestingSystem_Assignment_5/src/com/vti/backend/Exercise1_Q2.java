package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Ex1.Q2.TuyenSinh;

public class Exercise1_Q2 {
	private TuyenSinh tuyenSinh;
	private Scanner sc;

	public void Question2() {
		tuyenSinh = new TuyenSinh();
		sc = new Scanner(System.in);
		loadMenu();
	}

	private void loadMenu() {
		while (true) {
			System.out.println("*-----------------------------------THÍ SINH---------------------------------*");
			System.out.println("|==     1) Thêm mới thí sinh                                               ==|");
			System.out.println("|==     2) Hiện thị thông tin của thí sinh và khối thi của thí sinh        ==|");
			System.out.println("|==     3) Tìm kiếm theo số báo danh.                                      ==|");
			System.out.println("|==     4) Thoát khỏi chương trình                                         ==|");
			System.out.println("*----------------------------------------------------------------------------*");
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				tuyenSinh.addNewStudent();
				break;

			case 2:
				tuyenSinh.displayStudent();
				break;

			case 3:
				tuyenSinh.searchStudent();
				;
				break;

			case 4:
				return;

			default:
				System.out.println("Chọn đúng số trên MENU");
				break;
			}
		}
		
	}

}
