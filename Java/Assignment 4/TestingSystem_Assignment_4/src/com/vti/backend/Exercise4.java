package com.vti.backend;

import com.vti.entity.Ex4.Student;

public class Exercise4 {
		public void printStudent() {
			Student student1 = new Student(1, "Trường", "TN");
			Student student2 = new Student(2, "Linh", "NĐ");
			Student student3 = new Student(3, "Tú", "TN");
			Student student4 = new Student(4, "Hà", "TN");
			Student student5 = new Student(5, "Nhật", "HY");
			Student student6 = new Student(6, "Hoa", "HN");	
			student1.plusMark(5f);
			student2.plusMark(6f);
			student3.plusMark(7f);
			student4.plusMark(9f);
			student5.plusMark(6f);
			student6.plusMark(8f); 
			System.out.println(student1);
			System.out.println(student2);
			System.out.println(student3);
			System.out.println(student4);
			System.out.println(student5);
			System.out.println(student6);
		}
		
		public void Question2() {
			
		}
		
		
}
