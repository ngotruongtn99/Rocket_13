package com.vti.backend;

import java.util.Scanner;

public class Exercise4 {
	public void Question1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào xâu kí tự ");
		String a = sc.nextLine();
		String[] words = a.split(" ");
		System.out.println("Số kí tự của xâu kí tự là: " + words.length);
	}

	public void Question2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào xâu 1");
		String s1 = sc.nextLine();
		System.out.println("Nhập vào xâu 2");
		String s2 = sc.nextLine();
		s1 += " " + s2;
		System.out.println("Kết quả: " + s1);
	}

	public void Question3() {
		Scanner scanner = new Scanner(System.in);
		String name;
		System.out.println("Nhập Tên: ");
		name = scanner.nextLine();
		String firstCharacter = name.substring(0, 1).toUpperCase();
		String leftCharacter = name.substring(1);
		System.out.println("char at:" + name.charAt(1));
		name = firstCharacter + leftCharacter;
		System.out.println(name);
	}

	public void Question4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên: ");
		String name = sc.nextLine().trim();
		for (int i = 0; i < name.length(); i++) {
			String Character = name.substring(i, (i+1)).toUpperCase();
			System.out.println("Ký tự thứ " + (i + 1) + " là: " + Character);
		}
	}
	
	public void Question5() {
		Scanner sc =  new Scanner(System.in);
		System.out.println("Nhập vào họ của bạn");
		String firstName = sc.nextLine();
		System.out.println("Nhập vào tên của bạn");
		String lastName = sc.nextLine();
		System.out.println("Tên đầy đủ của bạn là: " + firstName+ " " + lastName );
	}
	
	public void Question6() {
		String fullName;
		String lastName = "", middleName = "", firstName = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập họ tên đầy đủ:");
		fullName = scanner.nextLine();
		// Chuẩn hóa xâu
		fullName = fullName.trim();
		String[] words = fullName.split(" ");
		lastName = words[0];
		firstName = words[words.length - 1];
		for (int i = 1; i <= words.length - 2; i++) {
		middleName += words[i] + " ";
		}
		System.out.println("Họ là: " + lastName);
		System.out.println("Tên đệm là: " + middleName);
		System.out.println("Tên là: " + firstName);
		scanner.close();
	}
	
	public void Question7() {
		Scanner scanner = new Scanner(System.in);
		String fullName;
		System.out.println("Nhập họ tên đầy đủ");
		fullName = scanner.nextLine();
		scanner.close();
		// remove space characters
		fullName = fullName.trim();
		fullName = fullName.replaceAll("\\s+", " ");
		System.out.println("test"+ fullName);
		String[] words = fullName.split(" ");
		fullName = "";
		for (String word : words) {
		String firstCharacter = word.substring(0, 1).toUpperCase();
		String leftCharacter = word.substring(1);
		word = firstCharacter + leftCharacter;
		fullName += word + " ";
		}
		System.out.println("Họ tên sau khi chuẩn hóa: " + fullName);
	}
}
