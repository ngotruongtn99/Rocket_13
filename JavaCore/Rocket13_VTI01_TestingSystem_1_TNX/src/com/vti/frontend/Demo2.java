package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class Demo2 {
public static void main(String[] args) {
	Department dep1 = new Department();
	dep1.id = 1;
	dep1.name = "Giám đốc";
	
	Department dep2 = new Department();
	dep2.id = 2;
	dep2.name = "Marketing";
	
	Department dep3 = new Department();
	dep3.id = 3;
	dep3.name = "Sale";
	
	Department[] GroupDep1 = {dep1, dep2, dep3};
	
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
	
			
	Group group2 = new Group();
	group2.id = 2;
	group2.name = "VTI Academy 2";
	
	Group group3 = new Group();
	group3.id = 3;
	group3.name = "VTI Academy 3";
			
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
	Group[] groupAcc2 = { group1, group3, group2 };
	acc2.groups = groupAcc2;
	acc2.createDate = LocalDate.of(2021, 05, 12);
	
	Account acc3 = new Account();
	acc3.id = 4;
	acc3.email = "email1@gmail.com";
	acc3.fullname = "fullname3";
	acc3.username = "username3";
	acc3.department = dep3;
	acc3.position = pos3;
	Group[] groupAcc3 = { group3, group2 };
	acc3.groups = groupAcc3;
	acc3.createDate = LocalDate.of(2021, 03, 30);
	
	//add Acc vào Group
	Account[] accGroup1 =  {acc1, acc2};
	group1.accounts = accGroup1;
	// Q1
	System.out.println("Question 1");
	if (acc2.department == null) {
		System.out.println("Nhân viên này chưa có phòng ban");
	} else {
		System.out.println("Phòng ban của nhân viên này là: " + acc2.department.name);
	} 
	
	// Q2
	System.out.println("\nQuestion 2");
	if (acc2.groups == null) {
		System.out.println("Nhâp viên này chưa có group");
	} else {
		int countgroup = acc2.groups.length;
		if (countgroup == 1 || countgroup == 2) {
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
		}if (countgroup == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		}if (countgroup >= 4) {
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}		
	}
	
	//Q3
	System.out.println("\nQuestion 3");
	System.out.println(acc2.department == null ? "Nhân viên này chưa có phòng ban." : "Phòng ban của nhân viên này là: " + acc2.department.name);

	//Q4
	System.out.println("\nQuestion 4");
	System.out.println(acc1.position.name != PositionName.DEV   ? "Người này không phải là Developer" : "Đây là Developer.");

	//Q5
	System.out.println("\nQuestion 5");
	System.out.println("Số lượng account trong nhóm thứ 1");
	
	if (group1.accounts == null) {
		System.out.println("Group chưa có thành viên.");
	} else {
		int count = group1.accounts.length;
		switch(count) {
		case 1:
			System.out.println("Nhóm có một thành viên");
			break;
			
		case 2:
			System.out.println("Nhóm có hai thành viên");
			break;
			
		case 3:
			System.out.println("Nhóm có ba thành viên");
			break;
		}
	}
	
	//Q6
	System.out.println("\nQuestion 6");
	if(acc2.groups == null)
	{
		System.out.println("Nhân viên này chưa có group");
	}else {
		int count = acc2.groups.length;
		switch(count) {
		case 1:
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			break;
			
		case 2:
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			break;
			
		case 3:
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;
			
		case 4:
			System.out.println("\"Nhân viên này là người hóng chuyện, tham gia tất cả các group");
			break;
		
		}
	}
	
	//Q7 
	
	System.out.println("\nQuestion 7");
	if (acc1.position == null) {
		System.out.println("Người này chưa có vị trí");
	} else {
		
		switch (acc1.position.name) {
		case DEV:
			System.out.println("Đây là Developer");
			break;

		case TEST:
			System.out.println("Người này không phải là Developer");
			break;
			
		case SCRUM_MASTER:
			System.out.println("Người này không phải là Developer");
			break;
			
		case PM:
			System.out.println("Người này không phải là Developer");
			break;
		}

	}
	
	//Q8
	System.out.println("\nQuestion 8");
	for (Account account : accGroup1) {
		System.out.println("Account ID: " + account.id + "\nUserName: " + account.username);
	}
	
	//Q9
	System.out.println("\nQuestion 9");
	for (Department department : GroupDep1) {
		System.out.println("Department ID: " + department.id + "\nDepartment Name: " + department.name);
	}
	
	//Q10
	
	System.out.println("\n----------FOR Question 10: IN thông tin Account ----------");
	
	Account[] accArray1 = { acc1, acc2 };
	for (int i = 0; i < accArray1.length; i++) {
		System.out.println("Thông tin account thứ " + (i+1) +" là: ");
		System.out.println("Email: " + accArray1[i].email);
		System.out.println("Full name: " + accArray1[i].fullname );
		System.out.println("Phòng ban: " + accArray1[i].department.name);
	}
	
	//Q11
	System.out.println("\n----------FOR Question 11: IN thông tin phòng ban ----------");
	for (int i = 0; i < GroupDep1.length; i++) {
		System.out.println("Thông tin Department thứ " + (i+1) + " là: ");
		System.out.println("ID: " + GroupDep1[i].id);
		System.out.println("Name: " + GroupDep1[i].name);
	}
	
	//Q12
	System.out.println("\n----------FOR Question 12: IN thông tin phòng ban ----------");
	for (int i = 0; i < 2; i++) {
		System.out.println("Thông tin Department thứ " + (i+1) + " là: ");
		System.out.println("ID: " + GroupDep1[i].id);
		System.out.println("Name: " + GroupDep1[i].name);
	}
	
	//Q13
	System.out.println("\n----------FOR Question 13: IN thông tin Account trừ acc thứ 2 ----------");
	Account[] accArray2 = { acc1, acc2, acc3  };
	for (int i = 0; i < accArray2.length ; i++) {
		if (i != 1) {
			System.out.println("Thông tin account thứ " + (i+1) +" là: ");
			System.out.println("Email: " + accArray2[i].email);
			System.out.println("Full name: " + accArray2[i].fullname );
			System.out.println("Phòng ban: " + accArray2[i].department.name);
		}
		
	}
	
	//Q14
	System.out.println("\n----------FOR Question 14: IN thông tin Account có id < 4 ----------");
	for (int i = 0; i < accArray2.length ; i++) {
		if (accArray2[i].id < 4) {
			System.out.println("Thông tin account thứ " + (i+1) +" là: ");
			System.out.println("Email: " + accArray2[i].email);
			System.out.println("Full name: " + accArray2[i].fullname );
			System.out.println("Phòng ban: " + accArray2[i].department.name);
		}
		
	}
	
	//Q15
	System.out.println("\n----------FOR Question 15: In ra các số chẵn nhỏ hơn hoặc bằng 20 ----------");
	for (int i = 0; i <= 20; i +=2) {
		System.out.println(i);
	}
	
	//Q16
	System.out.println("\n----------WHILE Question 16 ----------");
	//16.10
	System.out.println("\n----------WHILE Question 16.10 ----------");
//	int i = 0;
//	while ( i < accArray1.length) {
//		System.out.println("Thông tin account thứ " + (i+1) +" là: ");
//		System.out.println("Email: " + accArray1[i].email);
//		System.out.println("Full name: " + accArray1[i].fullname );
//		System.out.println("Phòng ban: " + accArray1[i].department.name);
//		i++;
//	}
//	
//	//Q16.11
	System.out.println("\nQuestion 16.11");
//	int j = 0;
//	while ( j < GroupDep1.length) {
//		System.out.println("Thông tin Department thứ " + (j+1) +" là: ");
//		System.out.println("ID: " + GroupDep1[j].id);
//		System.out.println("Name: " + GroupDep1[j].name );
//		j++;
//	}
//	
//	//Q16.12
	System.out.println("\nQuestion 16.12");
//	int k  =0;
//	while ( k < 2) {
//		System.out.println("Thông tin Department thứ " + (k+1) +" là: ");
//		System.out.println("ID: " + GroupDep1[k].id);
//		System.out.println("Name: " + GroupDep1[k].name );
//		k++;
//	}
////	
////	//Q16.13
	System.out.println("\nQuestion 16.13");
	int a = 0;
	while ( a < accArray2.length) {
		
		System.out.println("Thông tin account thứ " + (a+1) +" là: ");
		System.out.println("Email: " + accArray2[a].email);
		System.out.println("Full name: " + accArray2[a].fullname );
		System.out.println("Phòng ban: " + accArray2[a].department.name);
		a++;
		 if (a == 1) {
		        continue;
		      }
		
	}
	
	//Q16.14
	System.out.println("\nQuestion 16.14");
//	int b = 0;
//	while ( b < accArray2.length) {
//		 
//		System.out.println("Thông tin account thứ " + (b+1) +" là: ");
//		System.out.println("Email: " + accArray2[b].email);
//		System.out.println("Full name: " + accArray2[b].fullname );
//		System.out.println("Phòng ban: " + accArray2[b].department.name);
//		b++;
//		if (accArray2[b].id > 4) {
//	        break;
//	      }
//	}
	
	//Q16.15
	System.out.println("\nQuestion 16.15");
	int b = 0;
	while (b <=100) {
		
		System.out.println(b);
		b +=2;
		if (b > 20) {
			break;
	      }
	}
	
	//17.10
	System.out.println("\nQuestion 17.10");
//	int i = 0;
//	do {
//		System.out.println("Thông tin account thứ " + (i+1) +" là: ");
//		System.out.println("Email: " + accArray1[i].email);
//		System.out.println("Full name: " + accArray1[i].fullname );
//		System.out.println("Phòng ban: " + accArray1[i].department.name);
//		i++;
//	} while (i < accArray1.length);
	
	//Q17.11
	System.out.println("\nQuestion 17.11");
//	int i = 0;
//	do {
//		System.out.println("Thông tin Department thứ " + (i+1) + " là: ");
//		System.out.println("ID: " + GroupDep1[i].id);
//		System.out.println("Name: " + GroupDep1[i].name);
//		i ++;
//	} while (i < GroupDep1.length);
	
	//Q17.12
	System.out.println("\nQuestion 17.12");
//	int i = 0;
//	do {
//		System.out.println("Thông tin account thứ " + (i+1) +" là: ");
//		System.out.println("Email: " + accArray1[i].email);
//		System.out.println("Full name: " + accArray1[i].fullname );
//		System.out.println("Phòng ban: " + accArray1[i].department.name);
//		i++;
//	} while (i < 2);
	
	//Q17.13
	System.out.println("\nQuestion 17.13");
//	int i = 0;
//	do {
//		if (i == 1) { 
//	        continue;
//	      }
//		System.out.println("Thông tin account thứ " + (i+1) +" là: ");
//		System.out.println("Email: " + accArray2[i].email);
//		System.out.println("Full name: " + accArray2[i].fullname );
//		System.out.println("Phòng ban: " + accArray2[i].department.name);
//		i++;
//	
//	} while (i < accArray2.length);
	
	//Q17.14
	System.out.println("\nQuestion 17.14");
//	int i = 0;
//	do {
//		System.out.println("Thông tin account thứ " + (i+1) +" là: ");
//		System.out.println("Email: " + accArray2[i].email);
//		System.out.println("Full name: " + accArray2[i].fullname );
//		System.out.println("Phòng ban: " + accArray2[i].department.name);
//		i++;
//		if (accArray2[i].id > 4) {
//	        break;
//	      }
//	} while (i < accArray2.length);
	
	//Q17.15
	System.out.println("\nQuestion 17.15");
//	int c = 0;
//	do {
//		System.out.println(c);
//		c +=2;
//		if (c > 20) {
//			break;
//	      }
//	} while (c <= 100);
//	
	
}
}
