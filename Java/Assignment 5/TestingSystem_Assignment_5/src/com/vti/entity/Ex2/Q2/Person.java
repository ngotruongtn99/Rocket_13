package com.vti.entity.Ex2.Q2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
	private String name;
	private Gender gender;
	private LocalDate birthDay;
	private String address;
	public ArrayList<Person> personList;
	
	public Person() {
		super();
		personList = new ArrayList<Person>();
		
	}
	public enum Gender {
		MALE, FEMALE, UNKNOWN
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public Person(String name, Gender gender, LocalDate birthDay, String address) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthDay = birthDay;
		this.address = address;
	}
	public void inputInfor() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào tên:");
		this.name = sc.nextLine();
		System.out.println("Nhập vào giới tính(1. Nam, 2.Nữ, 3.Không xác định)");
		int numGender = sc.nextInt();
		switch (numGender) {
		case 1:
			this.gender = Gender.MALE;
			break;

		case 2:
			this.gender = Gender.FEMALE;
			break;
			
		case 3:
			this.gender = Gender.UNKNOWN;
			break;
		}
		System.out.println("Nhập vào ngày sinh");
		int day = sc.nextInt();
		System.out.println("Nhập vào tháng sinh");
		int month = sc.nextInt();
		System.out.println("Nhập vào năm sinh");
		int year = sc.nextInt();
		this.birthDay = LocalDate.of(year, month, day);
		System.out.println("Nhập vào địa chỉ");
		this.address = sc.next();
	}
	
	public String showInfor() {
		return "Person \nName: " + name + "\nGender: " + gender + "\nBirthDay: " + birthDay + "\nAddress: " + address;
	}

	}
