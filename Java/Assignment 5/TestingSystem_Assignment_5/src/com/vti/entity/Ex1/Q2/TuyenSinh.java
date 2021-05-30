package com.vti.entity.Ex1.Q2;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenSinh implements ITuyenSinh {
	private Scanner sc;
	private ArrayList<Student> studentList;

	public TuyenSinh() {
		sc = new Scanner(System.in);
		studentList = new ArrayList<Student>();
	}

	@Override
	public void addNewStudent() {
		System.out.println("Nhập vào họ tên của Thí sinh");
		String nameInput = sc.nextLine();
		System.out.println("Nhập vào địa chỉ");
		String addressInput = sc.nextLine();
		System.out.println("Nhập vào Mức ưu tiên");
		int priortyInput = sc.nextInt();
		System.out.println("Nhập vào Khối thi(A, B, C)");
		String khoiInput = sc.next();
		Student newStudent = new Student(nameInput, addressInput, priortyInput, new KhoiThi(khoiInput));
		studentList.add(newStudent);
	}

	@Override
	public void displayStudent() {
		for (Student student : studentList) {
			System.out.println(student.toString());
		}
	}

	@Override
	public void searchStudent() {
		System.out.println("Nhập vào ID của Thí sinh:");
		int idInput = sc.nextInt();
		for (Student student : studentList) {
			if (student.getId() == idInput) {
				System.out.println(student.toString());
			}
		}
	}

}
