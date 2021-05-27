package com.vti.frontend;

import java.util.ArrayList;
import com.vti.backend.Exercise4;
import com.vti.entity.Ex4.Student;

public class Program1 {
	public static void main(String[] args) {
		ArrayList<Student> arrStudent = new ArrayList<Student>();
		Student student1 = new Student(1, "Trường", "TN");
		Student student2 = new Student(2, "Linh", "NĐ");
		Student student3 = new Student(3, "Tú", "TN");
		Student student4 = new Student(4, "Hà", "TN");
		Student student5 = new Student(5, "Nhật", "HY");
		Student student6 = new Student(6, "Hoa", "HN");	
		
		student1.setMark(5f);
		student2.setMark(3f);
		student3.setMark((float) 7.5);
		student4.setMark((float) 8.5);
		student5.setMark((float) 9.2);
		student6.setMark((float) 4.5);
		
		
		arrStudent.add(student1);
		arrStudent.add(student2);
		arrStudent.add(student3);
		arrStudent.add(student4);
		arrStudent.add(student5);
		arrStudent.add(student6);
//		for (Student student : arrStudent) {
//			System.out.println(student.toString());
//		}
		 Exercise4 exercise4 = new Exercise4();
		 exercise4.printStudent();
		
		
	}

}
