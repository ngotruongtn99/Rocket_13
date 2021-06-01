package com.vti.backend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Ex1.Student;

public class Exercise1 {
	public void Question1() {
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		List<Student> listStudent = new ArrayList<Student>();
		listStudent.add(student1);
		listStudent.add(student2);
		listStudent.add(student3);

		for (Student student : listStudent) {
			System.out.println(student.toString());
		}

		System.out.println("Chuyển các sinh viên này sang Đại học công nghệ");
		Student.college = "Đại học công nghệ";

		for (Student student : listStudent) {
			System.out.println(student.toString());
		}

		System.out.println("Mỗi Student nộp quỹ 100k");
		Student.moneyGroup += 300;
		System.out.println("Tổng quỹ là: " + Student.moneyGroup);
		System.out.println("Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan");
		System.out.println("Tổng quỹ là: " + (Student.moneyGroup -= 50));
		System.out.println("Student thứ 2 lấy 20k đi mua bánh mì");
		System.out.println("Tổng quỹ là: " + (Student.moneyGroup -= 20));
		System.out.println("Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm");
		System.out.println("Tổng quỹ là: " + (Student.moneyGroup -= 150));
		System.out.println("cả nhóm mỗi người lại đóng quỹ mỗi người 50k");
		System.out.println("Tổng quỹ là: " + (Student.moneyGroup += 150));
	}
}
