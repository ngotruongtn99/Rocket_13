package com.vti.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

public class Exercise1_1 {
	private List<Student> listStudent;
	
	public Exercise1_1() {
		listStudent = new ArrayList<Student>();
	}
	public void Question1() {
		 
		System.out.println("Nhập số sinh viên bạn muốn thêm:");
		int num = ScannerUltis.inputIntPositive();
		for (int i = 0; i < num - 3 ; i++) {
			Student st = new Student("Student " + (i+1));
			listStudent.add(st);
		}
		Student st1 = new Student("Student's Name");
		Student st2 = new Student("Student's Name");
		Student st3 = new Student("Student's Name");
		listStudent.add(st1);
		listStudent.add(st2);
		listStudent.add(st3);
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
				for (Student student : listStudent) {
					System.out.println(student);
				}
				System.out.println("Số sinh viên được thêm là: " + listStudent.size());
				break;
				
			case 2:
				System.out.println("Phần tử thứ 4 của Student là: " + listStudent.get(3));
				break;
				
			case 3:
				System.out.println("Phần tử đầu của Students là: " + listStudent.get(0));
				System.out.println("Phần tử cuối của Students là: " + listStudent.get(num -1));
				break;
				
			case 4:
				System.out.println("Nhập vào tên sinh viên cần thêm: ");
				String name = ScannerUltis.inputString();
				Student newSt = new Student(name);
				listStudent.add(0, newSt);
				for (Student student : listStudent) {
					System.out.println(student);
				}
				break;
				
			case 5:
				System.out.println("Nhập vào tên sinh viên cần thêm: ");
				String name1 = ScannerUltis.inputString();
				Student newSt1 = new Student(name1);
				listStudent.add(newSt1);
				for (Student student : listStudent) {
					System.out.println(student);
				}
				break;
				
			case 6:
				Collections.reverse(listStudent);
				System.out.println("Đã đảo ngược vị trí");
				for (Student student : listStudent) {
					System.out.println(student);
				}
				break;
				
			case 7:
				findById();
				break;
				
			case 8:
				findByName();
				break;
				
			case 9:
				System.out.println("Các sinh viên trùng tên: ");
				for (int i = 0; i < listStudent.size(); i++) {
					for (int j = i + 1; j < listStudent.size(); j++) {
						if (listStudent.get(i).getName().equals(listStudent.get(j).getName())) {
							System.out.println(listStudent.get(i).toString());
						}
					}
				}
				break;
				
			case 10: 
				for (Student student : listStudent) {
					if (student.getId() == 2) {
						student.setName(null);
					}
				}
				for (Student student : listStudent) {
					System.out.println(student);
				}
				break;
				
			case 11:
				System.out.println("Nhập Id bạn muốn xóa");
				int id1 = ScannerUltis.inputIntPositive();
				Iterator<Student> iterator = listStudent.iterator();
				while (iterator.hasNext()) {
					Student student = iterator.next();
					if (student.getId() == id1) {
						iterator.remove();
					}
				}
				break;
				
			case 12:
				System.out.println("Tạo mới ArrayCopy:");
				List<Student> arrayCopy = new ArrayList<Student>();
				arrayCopy.addAll(listStudent);
				System.out.println("In phần tử trong ArrayCopy: ");
				for (Student student : arrayCopy) {
					System.out.println(student);
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

	private void findByName() {
		System.out.println("Nhập vào tên bạn muốn tìm kiếm: ");
		String name = ScannerUltis.inputString();
		for (Student student : listStudent) {
			if (student.getName().equals(name)) {
				System.out.println("Student bạn muốn tìm là: "+student);
			}
		}
	}
	private void findById() {
		System.out.println("Nhập vào id bạn muốn tìm: ");
		int id = ScannerUltis.inputIntPositive();
		System.out.println("Student bạn cần tìm là:");
		System.out.println(listStudent.get(id-1));
		
	}
}
