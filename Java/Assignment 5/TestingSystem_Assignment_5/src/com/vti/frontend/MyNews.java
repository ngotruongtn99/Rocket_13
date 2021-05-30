package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.Exercise1;

public class MyNews {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Exercise1 exercise1 = new Exercise1();
		while (true) {
			System.out.println("*-----------------------------------TIN TỨC---------------------------------*");
			System.out.println("|==     1) Insert news                                                    ==|");
			System.out.println("|==     2) View list news                                                 ==|");
			System.out.println("|==     3) Average rate                                                   ==|");
			System.out.println("|==     4) Exit                                                           ==|");
			System.out.println("*---------------------------------------------------------------------------*");
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				
				exercise1.insertNews();
				
				break;
				
			case 2:
				exercise1.disPlayNews();
				break;
				
			case 3:
				exercise1.averageRate();
				break;
				
			case 4: 
				return;

			default:
				System.out.println("Chọn đúng số trên MENU");
				break;
			}
		}
	}
}

