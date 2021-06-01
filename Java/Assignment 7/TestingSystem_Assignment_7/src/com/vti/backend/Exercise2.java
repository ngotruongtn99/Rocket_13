package com.vti.backend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Ex2.PrimaryStudent;
import com.vti.entity.Ex2.SecondaryStudent;
import com.vti.entity.Ex2.Student;

public class Exercise2 {
	public void Question2() {
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		Student student4 = new Student();
		List<Student> listStudents = new ArrayList<Student>();
		listStudents.add(student1);
		listStudents.add(student2);
		listStudents.add(student3);
		listStudents.add(student4);
		for (Student student : listStudents) {
			System.out.println(student.toString());
		}
	}
	public void Question3() {
//		Student student1 = new Student();
//		Student student2 = new Student();
//		Student student3 = new Student();
//		Student student4 = new Student();
//		List<Student> listStudents = new ArrayList<Student>();
//		listStudents.add(student1);
//		listStudents.add(student2);
//		listStudents.add(student3);
//		listStudents.add(student4);
//		for (Student student : listStudents) {
//			student.study();
//		}
		
		PrimaryStudent primaryStudent1 = new PrimaryStudent();
		PrimaryStudent primaryStudent2 = new PrimaryStudent();
		PrimaryStudent primaryStudent3 = new PrimaryStudent();
		SecondaryStudent secondaryStudent1 = new SecondaryStudent();
		SecondaryStudent secondaryStudent2 = new SecondaryStudent();
		SecondaryStudent secondaryStudent3 = new SecondaryStudent();
		List<PrimaryStudent> primaryStudents = new ArrayList<PrimaryStudent>();
		List<SecondaryStudent> secondaryStudents = new ArrayList<SecondaryStudent>();
		secondaryStudents.add(secondaryStudent3);
		secondaryStudents.add(secondaryStudent2);
		secondaryStudents.add(secondaryStudent1);
		primaryStudents.add(primaryStudent1);
		primaryStudents.add(primaryStudent2);
		primaryStudents.add(primaryStudent3);
		for (SecondaryStudent secondaryStudent : secondaryStudents) {
			secondaryStudent.SecondaryStudentStudy();
		}
		for (PrimaryStudent primaryStudent : primaryStudents) {
			primaryStudent.PrimaryStudentStudy();
		}
		
	}
}
