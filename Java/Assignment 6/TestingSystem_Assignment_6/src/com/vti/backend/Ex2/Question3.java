package com.vti.backend.Ex2;

public class Question3 {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3 };
		try {
			System.out.println(numbers[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Vượt quá số phần tử trong mảng");
		}
		
	}

}
