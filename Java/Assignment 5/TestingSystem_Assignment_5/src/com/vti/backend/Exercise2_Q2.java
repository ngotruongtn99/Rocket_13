package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Ex2.Q2.Person;
import com.vti.entity.Ex2.Q2.Student_Q2;

public class Exercise2_Q2 {

	public void Question2() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Person> personList = new ArrayList<Person>();
		while (true) {
			System.out.println("*-------------------------------DEMO QUESTION 2 ----------------------------*");
			System.out.println("|==     1) DEMO PERSON                                                    ==|");
			System.out.println("|==     2) DEMO STUDENT                                                   ==|");
			System.out.println("|==     3) SHOW INFORMATION                                               ==|");
			System.out.println("|==     4) Thoát khỏi chương trình                                        ==|");
			System.out.println("*---------------------------------------------------------------------------*");
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				Person  person = new Person();
				person.inputInfor();
				personList.add(person);
				
				break;

			case 2:
				Student_Q2 student = new Student_Q2();
				student.inputInfor();
				personList.add(student);
				student.scholarShip();
				break;

			case 3:
				for (Person person2 : personList) {
					System.out.println(person2.showInfor());
				}
				break;
				
			case 4:
				return;
			}
			
		}

	}
}
