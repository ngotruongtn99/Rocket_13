package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Ex2.Q3.HinhVuong;

public class Exercise2_Q3 {
	private HinhVuong canh;
	private Scanner sc;

	public Exercise2_Q3() {
		sc = new Scanner(System.in);
	}

	public void Question3() {
		while (true) {
			System.out.println("*----------------------------MENU----------------------------*");
			System.out.println("|==     1) Tạo hình vuông                                  ==|");
			System.out.println("|==     2) Tính diện tích                                  ==|");
			System.out.println("|==     3) Tính chu vi                                     ==|");
			System.out.println("|==     4) Thoát chương trình                              ==|");
			System.out.println("*------------------------------------------------------------*");
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				System.out.println("Nhập vào cạnh của Hình vuông");
				int a = sc.nextInt();
				canh = new HinhVuong(a);
				System.out.println("Tạo thanh công hình vuông có cạnh " + a);
				break;

			case 2:
				System.out.println(canh.dienTich());
				break;

			case 3:
				System.out.println(canh.chuVi());
				break;

			case 4:
				return;

			default:
				System.out.println("Chọn đúng MENU !!");
				break;
			}

		}
	}
}