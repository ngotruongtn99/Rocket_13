package com.vti.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

public class Exercise1_3 {
	private Set<Student> studentSet;

	public Exercise1_3() {
		studentSet = new HashSet<Student>();
	}

	public void Question3() {
		System.out.println("Nhập số sinh viên bạn muốn thêm:");

		int num = ScannerUltis.inputIntPositive();
		for (int i = 0; i < num - 3; i++) {
			Student st = new Student("Student " + (i + 1));
			studentSet.add(st);
		}
		Student st1 = new Student("Student's Name");
		Student st2 = new Student("Student's Name");
		Student st3 = new Student("Student's Name");
		studentSet.add(st1);
		studentSet.add(st2);
		studentSet.add(st3);
		while (true) {
			System.out.println("*----------------------------------------------------MENU----------------------------------------------*");
			System.out.println("|==     1) In ra tổng số phần tử của students                                                        ==|");
			System.out.println("|==     2) Lấy phần tử thứ 4 của students                                                            ==|");
			System.out.println("|==     3) In ra phần tử đầu và phần tử cuối của students                                            ==|");
			System.out.println("|==     4) Thêm 1 phần tử vào vị trí đầu của students                                                ==|");
			System.out.println("|==     5) Thêm 1 phần tử vào vị trí cuối của students                                               ==|");
			System.out.println("|==     6) Đảo ngược vị trí của students                                                             ==|");
			System.out.println("|==     7) Tạo 1 method tìm kiếm student theo id                                                     ==|");
			System.out.println("|==     8) Tạo 1 method tìm kiếm student theo name                                                   ==|");
			System.out.println("|==     9) Tạo 1 method để in ra các student có trùng tên                                            ==|");
			System.out.println("|==     10) Xóa name của student có id = 2                                                           ==|");
			System.out.println("|==     11) Delete student có id = 5;                                                                ==|");
			System.out.println("|==     11) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào studentCopies            ==|");
			System.out.println("|==     12) Thoát khỏi chương trình                                                                  ==|");
			System.out.println("*------------------------------------------------------------------------------------------------------*");
			int choose = ScannerUltis.inputInt();
			switch (choose) {
			case 1:
				for (Student student : studentSet) {
					System.out.println(student);
				}
				System.out.println("Số sinh viên được thêm là: " + studentSet.size());
				break;

			case 2:
				System.out.println("Phần tử thứ 4 của Student là: ");
				Iterator<Student> iterator = studentSet.iterator();
				for (int i = 0; i <= 2; i++) {
					iterator.next();
				}
				System.out.println(iterator.next());
				break;

			case 3:
				Iterator<Student> iterator1 = studentSet.iterator();
				System.out.println("Phần tử đầu của Students là: " + iterator1.next());

				for (int i = 0; i < (studentSet.size() - 2); i++) {
					iterator1.next();
				}
				System.out.println("Phần tử cuối của Students là: " + iterator1.next());

				break;

			case 4:
//				System.out.println("Nhập vào tên sinh viên cần thêm: ");
//				String name = ScannerUltis.inputString();
//				Student newSt = new Student(name);
//				studentSet.
//				for (Student student : studentSet) {
//					System.out.println(student);
//				}
				break;
//				
			case 5:
//				System.out.println("Nhập vào tên sinh viên cần thêm: ");
//				String name1 = ScannerUltis.inputString();
//				Student newSt1 = new Student(name1);
//				listStudent.add(newSt1);
//				for (Student student : listStudent) {
//					System.out.println(student);
//				}
				break;
//				
			case 6:
//				Collections.reverse(listStudent);
//				System.out.println("Đã đảo ngược vị trí");
//				for (Student student : listStudent) {
//					System.out.println(student);
//				}
				break;
//				
			case 7:
				System.out.println("Nhập vào ID cần tìm: ");
				int id = ScannerUltis.inputIntPositive();
				Iterator<Student> iterator2 = studentSet.iterator();
				for (int i = 0; i < studentSet.size(); i++) {
					Student stFind = iterator2.next();
					if (stFind.getId() == id) {
						System.out.println(stFind);
					}
				}
				break;

			case 8:
				System.out.println("Nhập vào tên cần tìm");
				String name = ScannerUltis.inputString();
				Iterator<Student> iterator3 = studentSet.iterator();
				for (int i = 0; i < studentSet.size(); i++) {
					Student nameSt = iterator3.next();
					if (nameSt.getName().equals(name)) {
						System.out.println(nameSt);
					}
				}
				break;

			case 9:
				System.out.println("Các sinh viên trùng tên: ");
				Iterator<Student> iterator4 = studentSet.iterator();
				for (int i = 0; i < studentSet.size(); i++) {
					Student nameSt1 = iterator4.next();

				}

				break;

			case 10:
				System.out.println("Set sau khi xóa: ");
				Iterator<Student> i9 = studentSet.iterator();
				for (int i = 0; i < 1; i++) {
					Student stFind9 = i9.next();
					if (stFind9.getId() == 2) {
						stFind9.setName(null);
					}

				}
//				Iterator<Student> i10 = studentSet.iterator();
//				for (int i = 0; i < studentSet.size(); i++) {
//					System.out.println(i10.next());
//				}

				break;

			case 11:
				System.out.println("Nhập vào ID của sinh viên cần xóa  khỏi danh sách: ");
				int id8 = ScannerUltis.inputIntPositive();
				System.out.println("Set sau khi xóa: ");
				Iterator<Student> i8 = studentSet.iterator();
				while (i8.hasNext()) {
					Student student = i8.next();
					if (student.getId() == id8) {
						i8.remove();
					}
				}

				break;

			case 12:
				System.out.println("Tạo Set mới để copy sang:");
				Set<Student> studentSetCopy = new HashSet<Student>();
				studentSetCopy.addAll(studentSet);
				System.out.println("Copy thành công");
				System.out.println("In danh sách phần tử trong studentSetCopy: ");
				Iterator<Student> i10_1 = studentSetCopy.iterator();
				for (int i = 0; i < studentSetCopy.size(); i++) {
					System.out.println(i10_1.next());
				}
				break;

			case 13:
				return;
			default:
				System.out.println("Nhập đúng MENU !!");
				break;
			}
		}
	}
}
