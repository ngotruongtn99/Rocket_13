package com.vti.frontend;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.entity.Answer;
import com.vti.entity.CategoryQuestion;
import com.vti.entity.CategoryQuestion.CategoryName;
import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;
import com.vti.entity.Question;
import com.vti.entity.TypeQuestion;
import com.vti.entity.TypeQuestion.TypeQuesionName;

public class Demo1 {

	public static void main(String[] args) {
		//Tạo Department
		
				Department dep1 = new Department();
				dep1.id = 1;
				dep1.name = "Giám đốc";
				
				Department dep2 = new Department();
				dep2.id = 2;
				dep2.name = "Marketing";
				
				Department dep3 = new Department();
				dep3.id = 3;
				dep3.name = "Sale";
				
				
				
				//Tạo Positon
				
				Position pos1 = new Position();
				pos1.id = 1;
				pos1.name = PositionName.DEV;
				
				Position pos2 = new Position();
				pos1.id = 2;
				pos1.name = PositionName.TEST;
				
				Position pos3 = new Position();
				pos1.id = 3;
				pos1.name = PositionName.SCRUM_MASTER;
				
				Position pos4 = new Position();
				pos4.id = 4;
				pos4.name = PositionName.PM;
				
				//Tạo Group
				
				Group group1 = new Group();
				group1.id = 1;
				group1.name = "VTI Academy 1";
				group1.createDate = LocalDate.of(2021, 01, 31);
						
				Group group2 = new Group();
				group2.id = 2;
				group2.name = "VTI Academy 2";
				group1.createDate = LocalDate.of(2021, 02, 12);
				
				Group group3 = new Group();
				group3.id = 3;
				group3.name = "VTI Academy 3";
				group1.createDate = LocalDate.of(2021, 04, 30);
						
				//Tạo Account
				
				Account acc1 = new Account();
				acc1.id = 1;
				acc1.email = "email1@gmail.com";
				acc1.fullname = "fullname1";
				acc1.username = "username1";
				acc1.department = dep1;
				acc1.position = pos1;
				Group[] groupAcc1 = { group1, group2 };
				acc1.groups = groupAcc1;
				acc1.createDate = LocalDate.of(2021, 03, 17);
				
				Account acc2 = new Account();
				acc2.id = 2;
				acc2.email = "email2@gmail.com";
				acc2.fullname = "fullname2";
				acc2.username = "username2";
				acc2.department = dep2;
				acc2.position = pos2;
				Group[] groupAcc2 = { group1, group3 };
				acc2.groups = groupAcc2;
				acc2.createDate = LocalDate.of(2021, 05, 12);
				
				Account acc3 = new Account();
				acc3.id = 1;
				acc3.email = "email1@gmail.com";
				acc3.fullname = "fullname1";
				acc3.username = "username1";
				acc3.department = dep3;
				acc3.position = pos3;
				Group[] groupAcc3 = { group3, group2 };
				acc3.groups = groupAcc3;
				acc3.createDate = LocalDate.of(2021, 03, 30);
				
				//ADD Acc vào Group
				Account[] accgroup1 = {acc1, acc2};
				group1.accounts = accgroup1;
				group1.creator = acc1;
				
				Account[] accgroup2 = {acc1, acc3};
				group2.accounts = accgroup2;
				group2.creator = acc2;
				
				Account[] accgroup3 = {acc3,acc2};
				group3.accounts = accgroup3;
				group3.creator = acc3;
				
				
				// Tạo TypeQuestion
				
				TypeQuestion tqes1 = new TypeQuestion();
				tqes1.id = 1;
				tqes1.name = TypeQuesionName.ESSAY;
				
				TypeQuestion tqes2 = new TypeQuestion();
				tqes2.id = 2;
				tqes2.name = TypeQuesionName.MULTIPLE_CHOICE;
				
				//Tạo CategoryQuestion
				
				CategoryQuestion cateqs1 = new CategoryQuestion();
				cateqs1.id = 1;
				cateqs1.name = CategoryName.JAVA;
				
				CategoryQuestion cateqs2 = new CategoryQuestion();
				cateqs2.id = 2;
				cateqs2.name = CategoryName.DOT_NET;
				
				CategoryQuestion cateqs3 = new CategoryQuestion();
				cateqs3.id = 3;
				cateqs3.name = CategoryName.SQL;
				
				CategoryQuestion cateqs4 = new CategoryQuestion();
				cateqs4.id = 1;
				cateqs4.name = CategoryName.POSTMAN;
				
				CategoryQuestion cateqs5 = new CategoryQuestion();
				cateqs5.id = 1;
				cateqs5.name = CategoryName.RUBY;
				
				//Tạo Question
				
				Question qs1 = new Question();
				qs1.id = 1;
				qs1.content = "Content 1";
				qs1.categoryQuestion = cateqs1;
				qs1.typeQuestion = tqes1;
				qs1.account = acc1;
				qs1.createDate = LocalDate.of(2021, 05, 10);
				
				
				Question qs2 = new Question();
				qs2.id = 2;
				qs2.content = "Content 2";
				qs2.categoryQuestion = cateqs2;
				qs2.typeQuestion = tqes1;
				qs2.account = acc1;
				qs2.createDate = LocalDate.of(2021, 04, 30);
				
				Question qs3 = new Question();
				qs3.id = 3;
				qs3.content = "Content 3";
				qs3.categoryQuestion = cateqs3;
				qs3.typeQuestion = tqes2;
				qs3.account = acc2;
				qs3.createDate = LocalDate.of(2021, 01, 16);
				
				Question qs4 = new Question();
				qs4.id = 4;
				qs4.content = "Content 4";
				qs4.categoryQuestion = cateqs4;
				qs4.typeQuestion = tqes2;
				qs4.account = acc2;
				qs4.createDate = LocalDate.of(2021, 02, 15);
				
				Question qs5 = new Question();
				qs5.id = 5;
				qs5.content = "Content 5";
				qs5.categoryQuestion = cateqs5;
				qs5.typeQuestion = tqes2;
				qs5.account = acc3;
				qs5.createDate = LocalDate.of(2021, 04, 10);
				
				//Tạo Answer
				
				Answer as1 = new Answer();
				as1.id = 1;
				as1.content = "Trả lời 1";
				as1.question = qs1;
				as1.isCorrect = true;
				
				Answer as2 = new Answer();
				as2.id = 2;
				as2.content = "Trả lời 2";
				as2.question = qs2;
				as2.isCorrect = false;
				
				Answer as3 = new Answer();
				as3.id = 3;
				as3.content = "Trả lời 3";
				as3.question = qs3;
				as3.isCorrect = true;
				
				Answer as4 = new Answer();
				as4.id = 4;
				as4.content = "Trả lời 4";
				as4.question = qs4;
				as4.isCorrect = false;
				
				Answer as5 = new Answer();
				as5.id = 5;
				as5.content = "Trả lời 5";
				as5.question = qs5;
				as5.isCorrect = true;
				
				//Tạo Exam
				
				Exam ex1 = new Exam();
				ex1.id = 1;
				ex1.code = "Code 1";
				ex1.title = "title 1";
				ex1.category = cateqs1;
				ex1.duration = 90;
				ex1.account = acc1;
//				ex1.createDate = LocalDate.of(2021, 02, 14);
				Question[] exqs1 = {qs1, qs2};
				ex1.questions = exqs1;
				
				
				Exam ex2 = new Exam();
				ex2.id = 2;
				ex2.code = "Code 2";
				ex2.title = "title 2";
				ex2.category = cateqs2;
				ex2.duration = 60;
				ex2.account = acc1;
	//			ex2.createDate = LocalDate.of(2021, 03, 15);
				Question[] exqs2 = {qs1, qs2, qs3};
				ex2.questions = exqs2;
				
				Exam ex3 = new Exam();
				ex3.id = 3;
				ex3.code = "Code 3";
				ex3.title = "title 3";
				ex3.category = cateqs3;
				ex3.duration = 90;
				ex3.account = acc1;
	//			ex3.createDate = LocalDate.of(2020, 10, 14);
				Question[] exqs3 = {qs4, qs2, qs3};
				ex3.questions = exqs3;
				
				Exam ex4 = new Exam();
				ex4.id = 4;
				ex4.code = "Code 4";
				ex4.title = "title 4";
				ex4.category = cateqs4;
				ex4.duration = 120;
				ex4.account = acc3;
	//			ex4.createDate = LocalDate.of(2021, 04, 21);
				Question[] exqs4 = {qs2, qs3, qs4};
				ex4.questions = exqs4;
				
				Exam ex5 = new Exam();
				ex5.id = 1;
				ex5.code = "Code 5";
				ex5.title = "title 5";
				ex5.category = cateqs5;
				ex5.duration = 90;
				ex5.account = acc1;
	//			ex5.createDate = LocalDate.of(2021, 05, 14);
				Question[] exqs5 = {qs1, qs2, qs3, qs5};
				ex5.questions = exqs5;
				
				//ADD Exam to Question
				Exam[] qex1 = {ex1, ex2, ex5};
				qs1.exams = qex1;
				
				Exam[] qex2 = {ex1, ex2, ex3, ex4, ex5};
				qs2.exams = qex2;
				
				Exam[] qex3 = { ex2, ex3, ex4, ex5};
				qs3.exams = qex3;
				
				Exam[] qex4 = {ex3, ex4};
				qs4.exams = qex4;
				
				Exam[] qex5 = {ex5};
				qs5.exams = qex5;
		
				
// Bắt đầu chương trình
				
		//Q16.10 
		Account[] accArray1 = {acc1, acc2, acc3};
		System.out.println("\n----------WHILE Question 16.10 ----------");
		int i = 0;
		while ( i < accArray1.length) {
			System.out.println("Thông tin account thứ " + (i+1) +" là: ");
			System.out.println("Email: " + accArray1[i].email);
			System.out.println("Full name: " + accArray1[i].fullname );
			System.out.println("Phòng ban: " + accArray1[i].department.name);
			i++;
			}	
		
		//Q16.11
		System.out.println("\n----------WHILE Question 16.11 ----------");
		
//		int i = 0;
//		while ( i < accArray1.length) {
//			System.out.println("Thông tin account thứ " + (i+1) +" là: ");
//			System.out.println("Email: " + accArray1[i].email);
//			System.out.println("Full name: " + accArray1[i].fullname );
//			System.out.println("Phòng ban: " + accArray1[i].department.name);
//			i++;
//			}	
		// Question 1: In ngẫu nhiên ra 1 số nguyên
		System.out.println("\n----------RANDOM NUMBER Question 1 ----------");
		Random random = new Random();
		int n = random.nextInt();
		System.out.println("Số nguyên ngẫu nhiên của bạn là: " + n);
		
		//Question 2:In ngẫu nhiên ra 1 số thực
		System.out.println("\n----------RANDOM NUMBER Question 2 ----------");
		float f1 = random.nextFloat();
		System.out.println("Số thực ngẫu nhiên của bạn là: " + f1);
		
//		Question 3: Khai báo 1 array bao gồm các tên của các bạn trong lớp, 
//			sau đó in ngẫu nhiên 
//			ra tên của 1 bạn
		System.out.println("\n----------RANDOM NUMBER Question 3 ----------");
		String[] nameArr = { "Long", "Trường", "Nhung", "Linh", "Trung"};
		int n1 = random.nextInt(nameArr.length);
		System.out.println("Tên ngẫu nhiên các bạn trong lớp là: " + nameArr[n1]);

//		Question 4:Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-1995
		System.out.println("\n----------RANDOM NUMBER Question 4 ----------");
//		int minDay = (int) LocalDate.of(1995, 07, 24).toEpochDay();
//		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
//		
//		long randomInt = minDay + random.nextInt(maxDay - minDay);
//		
//		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
//		System.out.println("Ngày ngẫu nhiên từ 24-07-1995 tới ngày 20-12-1995 là: " +randomDay);
		
//		Question 5: Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây

		System.out.println("\n----------RANDOM NUMBER Question 5 ----------");
		
		int minDay1 = (int) LocalDate.of(2020,05,21).toEpochDay();
		int maxDay1 = (int) LocalDate.now().toEpochDay();

		long randomInt1 = minDay1 + random.nextInt(maxDay1 - minDay1);
		
		LocalDate randomDay1 = LocalDate.ofEpochDay(randomInt1);
		System.out.println("Ngày ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây " +randomDay1);
		
//		Exercise 5: Input from console
//		Question 1: 
//			Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
		System.out.println("\n----------INPUT FROM CONSOLE Question 1 ----------");
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Mời bạn nhập vào số thứ 1: ");
//		int num1 = scanner.nextInt();
//		
//		System.out.println("Mời bạn nhập vào số thứ 2: ");
//		int num2 = scanner.nextInt();
//		
//		System.out.println("Mời bạn nhập vào số thứ 3: ");
//		int num3 = scanner.nextInt();
//		
//		System.out.println("Bạn đã nhập vào các số: " +num1 +" " + num2 + " " + num3);
		
//		Question 2: 
//			Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
		System.out.println("\n----------INPUT FROM CONSOLE Question 2 ----------");
//		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Mời bạn nhập vào số thực thứ 1: ");
//		float float1 = scanner.nextFloat();
//		
//		System.out.println("Mời bạn nhập vào số thực thứ 2: ");
//		float float2 = scanner.nextFloat();
//		
//		System.out.println("Bạn đã nhập vào các số thực: " + float1 +" " + float2);
		
//		Question 3: Viết lệnh cho phép người dùng nhập họ và tên
		System.out.println("\n----------INPUT FROM CONSOLE Question 3 ----------");
		
		
//		Question 5: 
//			Viết lệnh cho phép người dùng tạo account (viết thành method)
//			Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào 
//			chương trình sẽ chuyển thành Position.Dev, Position.Test, 
//			Position.ScrumMaster, Position.PM
		
		System.out.println("\n----------INPUT FROM CONSOLE Question 5 ----------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Mời bạn vào thông tin Account cần tạo ");
		Account acc = new Account();
		System.out.println("Nhập vào ID: ");
		acc.id = scanner.nextInt();
		System.out.println("Nhập vào Email:");
		acc.email = scanner.next();
		System.out.println("Nhập vào Full name: ");
		acc.fullname = scanner.next();
		System.out.println("Nhập vào Username: ");
		acc.username = scanner.next();
		System.out.println("Nhập Position(Nhập vào các số từ 1 đến 4 tương ứng với vị trí: 1.Dev, 2.Test, 3.Scrum Master, 4.PM)");
		int posNum = scanner.nextInt();
		switch (posNum) {
		case 1:
			Position pos = new Position();
			pos.name = PositionName.DEV;
			acc.position = pos;
			break;

		case 2:
			Position pos11 = new Position();
			pos11.name = PositionName.TEST;
			acc.position = pos11;
			break;
			
		case 3:
			Position pos22 = new Position();
			pos22.name = PositionName.SCRUM_MASTER;
			acc.position = pos22;
			break;
			
		case 4:
			Position pos33 = new Position();
			pos33.name = PositionName.PM;
			acc.position = pos33;
			break;
		}
		System.out.println("Thông tin Account vừa tạo là: " + "\nID: " + acc.id + "\nEmail: "+ acc.email + "\nFull Name: "+ acc.fullname + "\nUsername: "+ acc.username + "\nPosition: " + acc.position.name);
}
}
