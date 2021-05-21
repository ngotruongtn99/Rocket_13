package com.vti.frontend;

public class SystemOutPrintf {
public static void main(String[] args) {
	//Question 1: Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó
	System.out.println("Question 1");
//	int i = 5;
//	System.out.println(i);
	
//	Question 2: 
//		Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in 
//		ra số nguyên đó thành định dạng như sau: 100,000,000
	
	System.out.println("\nQuestion 2");
	
	int i = 100000000;
	System.out.println("%e"+ i);
}

}
