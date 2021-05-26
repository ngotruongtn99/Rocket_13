package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Student;

public class Exercise4 {
	
	public void setMark() {
		Student student1 = new Student(1, "Trường", "TN", 0);
		Student student2 = new Student(2, "Linh", "NĐ", 0);
		Student student3 = new Student(3, "Tú", "TN", 0);
		Student student4 = new Student(4, "Hà", "TN", 0);
		Student student5 = new Student(5, "Nhật", "HY", 0);
		Student student6 = new Student(6, "Hoa", "HN", 0);	
		
		ArrayList<Student> arrStudent = new ArrayList<Student>();
		arrStudent.add(student1);
		arrStudent.add(student2);
		arrStudent.add(student3);
		arrStudent.add(student4);
		arrStudent.add(student5);
		arrStudent.add(student6);
		System.out.println(arrStudent.toString());
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào Tên của sinh viên mà bạn muốn set điểm vào.");
		String nameInput = sc.next();
		int indexInput = -1;
		for (int i = 0; i < arrStudent.size(); i++) {
			if (arrStudent.get(i).getName().equals(nameInput)) {
				indexInput = i;
			}
		}
		if (indexInput < 0) {
			System.out.println("Nhập sai tên sinh viên, mời thử lại");
		} else {
			System.out.println("Nhập vào điểm bạn muốn set vào.");
			int markInput = sc.nextInt();
			arrStudent.get(indexInput).setMark(markInput);
			System.out.println("Sinh viên đã được thêm điểm là" + arrStudent.get(indexInput).toString());
		}
	}
	
}
