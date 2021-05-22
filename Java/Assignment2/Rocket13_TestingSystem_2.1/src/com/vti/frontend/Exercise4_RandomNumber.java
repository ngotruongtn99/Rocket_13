package com.vti.frontend;

import java.time.LocalDate;
import java.util.Random;

public class Exercise4_RandomNumber {

	public static void main(String[] args) {
//		Question 1: 
//			In ngẫu nhiên ra 1 số nguyên
		System.out.println("----------RANDOM NUMBER Question 1 ----------");
		Random random = new Random();
		int n = random.nextInt();
		System.out.println("Số nguyên ngẫu nhiên là: " +n );
		
//		Question 2: In ngẫu nhiên ra 1 số thực 
		System.out.println("\n----------RANDOM NUMBER Question 2 ----------");
		
		float f = random.nextFloat();
		System.out.println("Số thực ngẫu nhiên là: " + f);
		
//		Question 3: Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên 
//			ra tên của 1 bạn
		
		System.out.println("\n----------RANDOM NUMBER Question 3 ----------");
		
		String[] nameArray = {"Linh", "Long", "Tú", "Hà", "Nhật"};
		int n1 = random.nextInt(nameArray.length);
		System.out.println("Tên ngẫu nhiên 1 bạn trong lớp là: " + nameArray[n1]);
		
//		Question 4:Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-1995

		System.out.println("\n----------RANDOM NUMBER Question 4 ----------");
		
		int minDay = (int) LocalDate.of(1995, 07, 24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		
		long randomInt = minDay + random.nextInt(maxDay - minDay);
		
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println("Ngày ngẫu nhiên trong khoảng thời gian 24-07-1995 tới ngày 20-12-1995 là: " + randomDay);;
		
//		Question 5:Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây

		System.out.println("\n----------RANDOM NUMBER Question 5 ----------");
	
		int now = (int) LocalDate.now().toEpochDay();
		int randomDate = now - random.nextInt(365);
		LocalDate randomDay1 = LocalDate.ofEpochDay(randomDate);
		System.out.println("Ngày ngẫu nhiên trong 1 năm trở lại đây là: " + randomDay1);
		
//		Question 6:Lấy ngẫu nhiên 1 ngày trong quá khứ
		System.out.println("\n----------RANDOM NUMBER Question 6 ----------");
		int now1 = (int) LocalDate.now().toEpochDay();
		int randomDate1 = random.nextInt(now1);
		LocalDate randomDay2 = LocalDate.ofEpochDay(randomDate1);
		System.out.println("Ngày ngẫu nhiên trong quá khứ là: " + randomDay2);
		
//		Question 7:Lấy ngẫu nhiên 1 số có 3 chữ số
		
		int a = random.nextInt(900) + 100;
		System.out.println("Số ngẫu nhiên có 3 chữ số là: " + a);
}
}
