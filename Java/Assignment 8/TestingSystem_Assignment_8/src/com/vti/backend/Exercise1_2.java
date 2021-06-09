package com.vti.backend;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

public class Exercise1_2 {
	private Stack<Student> stackStudents;
	private Queue<Student> queueStudents;

	public Exercise1_2() {
		stackStudents = new Stack<Student>();
		queueStudents = new LinkedList<Student>();
	}

	public void Question2_a() {
		Student st1 = new Student("Nguyễn Văn Nam");
		Student st2 = new Student("Nguyễn Văn Huyên");
		Student st3 = new Student("Trần Văn Nam");
		Student st4 = new Student("Nguyễn Văn A");
		stackStudents.push(st1);
		stackStudents.push(st2);
		stackStudents.push(st3);
		stackStudents.push(st4);
		System.out.println("Nhập số sinh viên bạn muốn thêm:");
		int num = ScannerUltis.inputIntPositive();
		for (int i = 0; i < num - 4; i++) {
			Student st = new Student("Student " + (i + 1));
			stackStudents.push(st);
		}
		System.out.println("Thêm thành công " + num + " học sinh tới phỏng vấn");
		for (Student student : stackStudents) {
			System.out.println(student);
		}
		System.out.println(stackStudents.size());
		System.out.println("Sinh viên đến muộn nhất: " + stackStudents.peek());
		System.out.println("Thứ tự sinh viên theo thứ tự từ muộn nhất đến sớm nhất dùng Stack: ");
				for (int i = 0; i < stackStudents.size(); i++) {
				System.out.println(stackStudents.pop());
				}
				System.out.println("Số sinh viên còn lại trong Stack: " + stackStudents.size());
		printStudent();

	}

	private void printStudent() {
		System.out.println("Thứ tự học sinh tới phỏng vấn từ sớm nhất tới muộn nhất dùng Stack là: ");
		Iterator<Student> iterator = stackStudents.iterator();
		while (iterator.hasNext()) {
			Student st = iterator.next();
			System.out.println(st);
		}
	}

	public void Question2_b() {
		Student st1 = new Student("Nguyễn Văn Nam");
		Student st2 = new Student("Nguyễn Văn Huyên");
		Student st3 = new Student("Trần Văn Nam");
		Student st4 = new Student("Nguyễn Văn A");
		queueStudents.add(st1);
		queueStudents.add(st2);
		queueStudents.add(st3);
		queueStudents.add(st4);
		System.out.println("Nhập số sinh viên bạn muốn thêm:");
		int num = ScannerUltis.inputIntPositive();
		System.out.println("Thêm thành công " + num + " học sinh tới phỏng vấn");
		for (int i = 0; i < num - 4; i++) {
			Student st = new Student("Student " + (i + 1));
			queueStudents.add(st);
		}
		for (Student student : queueStudents) {
			System.out.println(student);
		}
		System.out.println("Thứ tự học sinh từ muộn nhất tới sớm nhất là");
		
		for (int i = 0 ; i < num ; i++) {
			System.out.println(queueStudents.poll());
		}
		System.out.println("Danh sách sinh viên còn lại trong Queue: " + queueStudents);
	}
}
