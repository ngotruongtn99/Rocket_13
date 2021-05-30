package com.vti.backend.Ex2;

import java.util.Scanner;

public class Question1_2 {

	public void Question1_2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào số bị chia: ");
		int num1 = sc.nextInt();
		System.out.println("Nhập vào số chia: ");
		int num2 = sc.nextInt();
		try {
			System.out.println("Kết quả: " + divide(num1, num2));
		} catch (ArithmeticException e) {
			System.err.println("Không thể thực hiện phép chia cho số 0");
		} finally {
			System.out.println("divide completed!");
		}
	}

	private static float divide(int a, int b) {
		return (float) (a / b);
	}

}
