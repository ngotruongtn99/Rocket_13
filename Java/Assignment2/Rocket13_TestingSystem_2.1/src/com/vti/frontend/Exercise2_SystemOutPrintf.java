package com.vti.frontend;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.vti.entity.Account;
import com.vti.entity.Department;

public class Exercise2_SystemOutPrintf {

	public static void main(String[] args) {
//		Question 1: 
//			Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số 
//			nguyên đó
		
		System.out.println("--------- SYSTEM.OUT.PRINTF Question 1 ---------");
		int i;
		i = 5;
		System.out.printf("%d%n", i);
		
//		Question 2: 
//			Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in 
//			ra số nguyên đó thành định dạng như sau: 100,000,000
		System.out.println("\n--------- SYSTEM.OUT.PRINTF Question 2 ---------");
		int a;
		a = 100000000;
		System.out.printf("%,d%n", a);
		
//		Question 3: 
//			Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số 
//			thực đó chỉ bao gồm 4 số đằng sau
		System.out.println("\n--------- SYSTEM.OUT.PRINTF Question 3 ---------");
		float f;
		f = (float) 5.567098;
		System.out.printf("%.4f%n", f);
		
//		Question 4: 
//			Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định 
//			dạng như sau:
//			Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau: 
//			Tên tôi là "Nguyễn Văn A" và tôi đang độc thân
		System.out.println("\n--------- SYSTEM.OUT.PRINTF Question 4 ---------");
		String Hoten = "Nguyễn Văn A";
		System.out.printf("Tên tôi là \"" + Hoten + "\" và tôi đang độc thân \n");
		
//		Question 5:
//			Lấy thời gian bây giờ và in ra theo định dạng sau:
//			24/04/2020 11h:16p:20s
			System.out.println("\n--------- SYSTEM.OUT.PRINTF Question 5 ---------");
			String d = "dd/MM/yyyy HH:mm:ss";
			SimpleDateFormat dateFomat = new SimpleDateFormat(d);
			String date = dateFomat.format(new Date());
			System.out.println(date);
			
//		Question 6:
			Department dep1 = new Department();
			dep1.id = 1;
			dep1.name = "Giám đốc";
			
			Department dep2 = new Department();
			dep2.id = 2;
			dep2.name = "Marketing";
			
			Department dep3 = new Department();
			dep3.id = 3;
			dep3.name = "Sale";
			
			Account acc1 = new Account();
			acc1.id = 1;
			acc1.email = "email1@gmail.com";
			acc1.fullname = "fullname1";
			acc1.username = "username1";
			acc1.department = dep1;
			
			Account acc2 = new Account();
			acc2.id = 2;
			acc2.email = "email2@gmail.com";
			acc2.fullname = "fullname2";
			acc2.username = "username2";
			acc2.department = dep2;
			
			Account acc3 = new Account();
			acc3.id = 1;
			acc3.email = "email1@gmail.com";
			acc3.fullname = "fullname3";
			acc3.username = "username3";
			acc3.department = dep3;
			
			Account[] accArray = {acc1, acc2, acc3};
//			In ra thông tin account (như Question 8 phần FOREACH) theo định dạng 
//			table (giống trong Database)	
			System.out.println("\n--------- SYSTEM.OUT.PRINTF Question 6 ---------");
			String leftAlignFormat = "| %-25s ";
			String midAlignFormat = "| %-25s ";
			String rightAlignFormat = "| %-16s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        THÔNG TIN ACCOUNT                                 |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "Email");
			System.out.format(midAlignFormat, "FullName");
			System.out.format(rightAlignFormat, "DepartmentName");
			System.out.format("+--------------------------------------------------------------------------+%n");
		for (int j = 0; j < accArray.length; j++) {
			System.out.format(leftAlignFormat, accArray[j].email);
			System.out.format(midAlignFormat, accArray[j].fullname);
			System.out.format(rightAlignFormat, accArray[j].department.name);
		}
			System.out.format("+--------------------------------------------------------------------------+%n");
		
}
}
