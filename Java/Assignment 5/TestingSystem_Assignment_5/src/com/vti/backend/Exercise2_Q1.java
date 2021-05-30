package com.vti.backend;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.vti.entity.Ex2.Q1.Student;

public class Exercise2_Q1 {

	public void Question1() {
		 ArrayList<Student> studentList = new ArrayList<Student>();
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("*----------------------------MENU----------------------------*");
			System.out.println("|==     1) Thêm mới Sinh viên                              ==|");
			System.out.println("|==     2) Hiển thị thông tin Sinh viên                    ==|");
			System.out.println("|==     3) Kêu gọi cả lớp điểm danh                        ==|");
			System.out.println("|==     4) Gọi nhóm 1 đi học bài                           ==|");
			System.out.println("|==     5) Gọi nhóm 2 đi học vệ sinh                       ==|");
			System.out.println("|==     6) Thoát chương trình                              ==|");
			System.out.println("*------------------------------------------------------------*");
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				Random random = new Random();
				for (int i = 0; i < 10; i++) {
					Student student = new Student("Student "+ (i+1), random.nextInt(3)+1);
					studentList.add(student);
				}
				System.out.println("Tạo thành công");
				break;

			case 2:
				String leftAlignFormat = "| %-22s ";
				String left1AlignFormat = "| %-24s ";
				String right1AlignFormat = "| %-20s |%n";
				System.out.format("+--------------------------------------------------------------------------+%n");
				System.out.format("|                               STUDENT INFORMATION                        |%n");
				System.out.format("+--------------------------------------------------------------------------+%n");
				System.out.format(leftAlignFormat, "ID");
				System.out.format(left1AlignFormat, "NAME");
				System.out.format(right1AlignFormat, "GROUP");
			
				System.out.format("+--------------------------------------------------------------------------+%n");
				for (Student student_Q1 : studentList) {
					System.out.format(leftAlignFormat, student_Q1.getId());
					System.out.format(left1AlignFormat, student_Q1.getName());
					System.out.format(right1AlignFormat, student_Q1.getGroup());
				}
				System.out.format("+--------------------------------------------------------------------------+%n");	
			
				break;
				
			case 3:
				for (Student student_Q1 : studentList) {
					student_Q1.diemDanh();
				}
				break;
				
			case 4:
				for (Student student_Q1 : studentList) {
					if(student_Q1.getGroup() == 1) {
						student_Q1.hocBai();
					}
				}
				break;
				
			case 5:
				for (Student student_Q1 : studentList) {
					if(student_Q1.getGroup() == 2) {
						student_Q1.diDonVeSinh();
					}
				}
				break;
				
			case 6:
				return;
				
				default:
					System.out.println("Mời nhập đúng trên MENU");
					break;
			}
		}
	}
	
}
