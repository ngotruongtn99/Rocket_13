package com.vti.backend.Ex2;

import java.util.Scanner;

import com.vti.entity.Ex2.Department;

public class Question4 {
	public static void main(String[] args) {
		
		try {
			getIndex();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Cannot find department");
		}

	}

	private static void getIndex() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào phần tử bạn muốn lấy thông tin");
		int index = sc.nextInt();
		Department dep1 = new Department("Sale");
		Department dep2 = new Department("Marketing");
		Department dep3 = new Department("IT");
		Department[] arrDept = { dep1, dep2, dep3 };
		System.out.println(arrDept[index-1]);
		return;

	}
}
