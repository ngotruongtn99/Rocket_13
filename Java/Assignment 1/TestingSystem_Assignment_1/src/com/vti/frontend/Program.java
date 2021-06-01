package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Answer;
import com.vti.entity.CategoryQuestion;
import com.vti.entity.CategoryQuestion.CategoryName;
import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.TypeQuestion;
import com.vti.entity.TypeQuestion.TypeQuesionName;
import com.vti.entity.Position.PositionName;
import com.vti.entity.Question;

public class Program {
	public static void main(String[] args) {
		System.out.println("Hello VTI !!");
		
//		Question 2: 
//			Tạo file Program.java có chứa main() method và khởi tạo ít nhất 3 đối tượng
//			đối với mỗi table trong java
		
		
		// Tạo Department

		Department dep1 = new Department();
		dep1.id = 1;
		dep1.name = "Giám đốc";

		Department dep2 = new Department();
		dep2.id = 2;
		dep2.name = "Marketing";

		Department dep3 = new Department();
		dep3.id = 3;
		dep3.name = "Sale";

		// Tạo Positon

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

		// Tạo Group

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

		// Tạo Account

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

		// ADD Acc vào Group
		Account[] accgroup1 = { acc1, acc2 };
		group1.accounts = accgroup1;
		group1.account = acc1;

		Account[] accgroup2 = { acc1, acc3 };
		group2.accounts = accgroup2;
		group2.account = acc2;

		Account[] accgroup3 = { acc3, acc2 };
		group3.accounts = accgroup3;
		group3.account = acc3;

		// Tạo TypeQuestion

		TypeQuestion tqes1 = new TypeQuestion();
		tqes1.id = 1;
		tqes1.name = TypeQuesionName.ESSAY;

		TypeQuestion tqes2 = new TypeQuestion();
		tqes2.id = 2;
		tqes2.name = TypeQuesionName.MULTIPLE_CHOICE;

		// Tạo CategoryQuestion

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

		// Tạo Question

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

		// Tạo Answer

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

		// Tạo Exam

		Exam ex1 = new Exam();
		ex1.id = 1;
		ex1.code = "Code 1";
		ex1.title = "title 1";
		ex1.category = cateqs1;
		ex1.duration = 90;
		ex1.account = acc1;
		ex1.createDate = LocalDate.of(2021, 02, 14);
		Question[] exqs1 = { qs1, qs2 };
		ex1.questions = exqs1;

		Exam ex2 = new Exam();
		ex2.id = 2;
		ex2.code = "Code 2";
		ex2.title = "title 2";
		ex2.category = cateqs2;
		ex2.duration = 60;
		ex2.account = acc1;
		ex2.createDate = LocalDate.of(2021, 03, 15);
		Question[] exqs2 = { qs1, qs2, qs3 };
		ex2.questions = exqs2;

		Exam ex3 = new Exam();
		ex3.id = 3;
		ex3.code = "Code 3";
		ex3.title = "title 3";
		ex3.category = cateqs3;
		ex3.duration = 90;
		ex3.account = acc1;
		ex3.createDate = LocalDate.of(2020, 10, 14);
		Question[] exqs3 = { qs4, qs2, qs3 };
		ex3.questions = exqs3;

		Exam ex4 = new Exam();
		ex4.id = 4;
		ex4.code = "Code 4";
		ex4.title = "title 4";
		ex4.category = cateqs4;
		ex4.duration = 120;
		ex4.account = acc3;
		ex4.createDate = LocalDate.of(2021, 04, 21);
		Question[] exqs4 = { qs2, qs3, qs4 };
		ex4.questions = exqs4;

		Exam ex5 = new Exam();
		ex5.id = 1;
		ex5.code = "Code 5";
		ex5.title = "title 5";
		ex5.category = cateqs5;
		ex5.duration = 90;
		ex5.account = acc1;
		ex5.createDate = LocalDate.of(2021, 05, 14);
		Question[] exqs5 = { qs1, qs2, qs3, qs5 };
		ex5.questions = exqs5;

		// ADD Exam to Question
		Exam[] qex1 = { ex1, ex2, ex5 };
		qs1.exams = qex1;

		Exam[] qex2 = { ex1, ex2, ex3, ex4, ex5 };
		qs2.exams = qex2;

		Exam[] qex3 = { ex2, ex3, ex4, ex5 };
		qs3.exams = qex3;

		Exam[] qex4 = { ex3, ex4 };
		qs4.exams = qex4;

		Exam[] qex5 = { ex5 };
		qs5.exams = qex5;

		// Question 3: Trong file Program.java, hãy in ít nhất 1 giá trị của mỗi đối
		// tượng ra

		// In thông tin Account
		System.out.println("In thông tin account trên hệ thống");
		System.out.println("Thông tin Account 1");
		System.out.println("ID: " + acc1.id);
		System.out.println("Email: " + acc1.email);
		System.out.println("Group: " + acc1.groups[0].name + ", " + acc1.groups[1].name);

		// In thông tin Department
		System.out.println("\nIn thông tin Department trên hệ thống");
		System.out.println("Thông tin Deparment 1");
		System.out.println("ID: " + dep1.id);
		System.out.println("Name: " + dep1.name);

		// In thông tin Position
		System.out.println("\nIn thông tin Position trên hệ thống");
		System.out.println("Thông tin Position 1");
		System.out.println("ID: " + pos1.id);
		System.out.println("Name: " + pos1.name);

		// In thông tin Group
		System.out.println("\nIn thông tin Group trên hệ thống");
		System.out.println("Thông tin Group 1");
		System.out.println("ID: " + group1.id);
		System.out.println("Name: " + group1.name);
		System.out.println("Account trong Group 1: " + group1.accounts[0].fullname + " " + group1.accounts[1].fullname);
		System.out.println("Người tạo Group 1: " + group1.account.email);
		System.out.println("Ngày tạo Group 1: " + group1.createDate);

		// In thông tin TypeQuestion
		System.out.println("\nIn thông tin TypeQuestion trên hệ thống");
		System.out.println("Thông tin TypeQuestion 1");
		System.out.println("ID: " + tqes1.id);
		System.out.println("Name: " + tqes1.name);

		// In thông tin CategoryQuestion
		System.out.println("\nIn thông tin CategoryQuestion trên hệ thống");
		System.out.println("Thông tin CategoryQuestion 1");
		System.out.println("ID: " + cateqs1.id);
		System.out.println("Name: " + cateqs1.name);

		// In thông tin Question
		System.out.println("\nIn thông tin Question trên hệ thống");
		System.out.println("Thông tin Question 1");
		System.out.println("ID: " + qs1.id);
		System.out.println("Nội dung câu hỏi: " + qs1.content);
		System.out.println("Chủ đề: " + qs1.categoryQuestion.name);
		System.out.println("Loại câu hỏi: " + qs1.typeQuestion.name);
		System.out.println("Người tạo câu hỏi: " + qs1.account.fullname);
		System.out.println("Có trong các đề thi: " + qs1.exams[0].id + " " + qs1.exams[1].id + " " + qs1.exams[2].id);
		System.out.println("Ngày tạo câu hỏi: " + qs1.createDate);

		// In thông tin Answer
		System.out.println("\nIn thông tin Answer trên hệ thống");
		System.out.println("Thông tin Answer 1");
		System.out.println("ID: " + as1.id);
		System.out.println("Nội dung câu trả lời: " + as1.content);
		System.out.println("Loại câu hỏi: " + as1.question.id);
		System.out.println("Đúng/Sai?: " + as1.isCorrect);

		// In thông tin Exam
		System.out.println("\nIn thông tin Exam trên hệ thống");
		System.out.println("Thông tin Exam 1");
		System.out.println("ID: " + ex1.id);
		System.out.println("Mã đề thi " + ex1.code);
		System.out.println("Tiêu đề của đề thi: " + ex1.title);
		System.out.println("Chủ đề thi: " + ex1.category.name);
		System.out.println("Thời gian thi: " + ex1.duration);
		System.out.println("Các câu hỏi trong đề thi: " + ex1.questions[0].id + " " + ex1.questions[1].id);
		System.out.println("Người tạo đề: " + ex1.account.fullname);
		System.out.println("Ngày tạo đề thi: " + ex1.createDate);

		
	}
}
