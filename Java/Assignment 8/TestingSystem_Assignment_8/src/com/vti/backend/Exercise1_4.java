package com.vti.backend;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

public class Exercise1_4 {
	public void Question4() {
		Set<Student> studentSet = new HashSet<Student>();
		System.out.println("Nhập số lượng sinh viên");
		int num = ScannerUltis.inputIntPositive();
		for (int i = 0; i < num; i++) {
			System.out.println("Nhập vào tên của sinh viên");
			String nameSt = ScannerUltis.inputString();
			Student st = new Student(nameSt);
			studentSet.add(st);
		}
		System.out.println("Tổng số sinh viên là: " + studentSet.size());
		
		Iterator<Student> iterator = studentSet.iterator();
		for (int i = 0; i < studentSet.size(); i++) {
			System.out.println(iterator.next());
		}
	}
}
