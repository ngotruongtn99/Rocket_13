package com.vti.entity.Ex2.Q2;

import java.util.Scanner;

import com.vti.entity.Ex2.Q2.Person.Gender;

public class Student_Q2 extends Person {

	private int stuID;
	private float averageMark;
	private String mail;
	private static int COUNT = 0;
	private Scanner sc;
	
	
	public Student_Q2(float averageMark, String mail) {
		super();
		COUNT++;
		this.stuID = COUNT;
		this.averageMark = averageMark;
		this.mail = mail;
	}
	
	

	public Student_Q2() {
		super();
		sc = new Scanner(System.in);
	}


	public void setAverageMark(float averageMark) {
		this.averageMark = averageMark;
	}


	public int getStuID() {
		return stuID;
	}


	public void setStuID(int stuID) {
		this.stuID = stuID;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public float getAverageMark() {
		return averageMark;
	}


	@Override
	public void inputInfor() {
		super.inputInfor();
		System.out.println("Nhập điểm trung bình của Sinh viên");
		this.averageMark = sc.nextFloat();
		System.out.println("Nhập Email của sinh viên");
		this.mail = sc.next();
	}

	@Override
	public String showInfor() {
		return super.showInfor() + "\nStudent: ID" + stuID + "\nEmail: " + mail + "\nAverageMark: " + averageMark;
	}



	public void scholarShip() {
		for (Person person : personList) {
			if(person instanceof Student_Q2) {
				if (((Student_Q2) person).getAverageMark() > 8.0) {
					System.out.println("Sinh viên " + person.getName() + " đã đủ điều kiện nhân học bổng! ");
				}else {
					System.out.println("Sinh viên " + person.getName() + " chưa đủ điều kiện nhân học bổng! ");
				}
			}
		}
	}

}
