package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Ex2.Q3.HinhVuong;
import com.vti.entity.Ex2.Q4.MyMath;

public class Exercise2_Q4 {
	private Scanner sc;

	public Exercise2_Q4() {
		sc = new Scanner(System.in);
		
	}
	
	public void Question4() {
		MyMath myMath = new MyMath();
		while (true) {
			System.out.println("*----------------------------MATH----------------------------*");
			System.out.println("|==     1) Tính tổng 2 số nguyên                           ==|");
			System.out.println("|==     2) Tính tổng 2 số thực                             ==|");
			System.out.println("|==     3) Tính tổng 2 số kiểu BYTE                        ==|");
			System.out.println("|==     4) Thoát chương trình                              ==|");
			System.out.println("*------------------------------------------------------------*");
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				System.out.println("Nhập vào số a");
				int a = sc.nextInt();
				System.out.println("Nhập vào số b");
				int b = sc.nextInt();
				System.out.println( myMath.sum(a, b));
				break;

			case 2:
				System.out.println("Nhập vào số a");
				float c = sc.nextFloat();
				System.out.println("Nhập vào số b");
				float d = sc.nextFloat();
				System.out.println( myMath.sum(c, d));
				break;

			case 3:
				System.out.println("Nhập vào số a");
				byte e = sc.nextByte();
				System.out.println("Nhập vào số b");
				byte f = sc.nextByte();
				System.out.println( myMath.sum(e, f));
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

