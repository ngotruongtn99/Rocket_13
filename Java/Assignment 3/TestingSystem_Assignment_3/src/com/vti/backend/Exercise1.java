package com.vti.backend;

import java.util.Scanner;

public class Exercise1 {

	public void Question1() {
		System.out.println("---------------------Question 1----------------------");
		float Salary1;
		float Salary2;
		
		Salary1 = (float) 5240.5;
		Salary2 = (float) 10970.055;
		
		System.out.println("Salary1: " + Salary1 + " | Salary2" + Salary2);
		
		int roundSalary1 = (int) Salary1;
		int roundSalary2 = (int) Salary2;
		
		System.out.println("roundSalary1: " + roundSalary1 + " | roundSalary2" + roundSalary2);
	}
	
	public void Question2() {
		System.out.println("\n---------------------Question 2----------------------");
		int min = 0;
		int max = 99999;
		int a = (int) (Math.random() * max) + min;
		while (a < 10000) {
		a = a * 10;
		}
		System.out.println("Số ngẫu nhiên: " + a);
	}
	
	public void Question3() {
		System.out.println("\n---------------------Question 3----------------------");
		int min = 0;
		int max = 99999;
		int a = (int) (Math.random() * max) + min;
		while (a < 10000) {
		a = a * 10;
		}
		System.out.println("Số ngẫu nhiên: " + a);
		String b = String.valueOf(a);
		System.out.println("Hai số cuối là: " + b.substring(3));
	}
	
	public void Question4() {
		System.out.println("\n---------------------Question 4----------------------");
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập vào số a: ");
		int a = sc.nextInt();
		System.out.print("Nhập vào số b: ");
		int b = sc.nextInt();
		System.out.println("Thương của chúng là: " + (a/b));
		
	}
}
