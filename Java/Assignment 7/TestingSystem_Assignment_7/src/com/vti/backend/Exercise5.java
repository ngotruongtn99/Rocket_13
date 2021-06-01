package com.vti.backend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Ex5.Student;
import com.vti.ultis.FileUltis;
import com.vti.ultis.IOManager;
import com.vti.ultis.ScannerUltis;

public class Exercise5 {
	public void Question1() throws Exception {
		List<Student> listStudent = new ArrayList<Student>();
		for (int i = 0; i < 3; i++) {
			System.out.println("Nhập vào tên sinh viên " + (i + 1));
			String name = ScannerUltis.inputString();
			Student student = new Student(name);
			listStudent.add(student);

		}
//		Write 3 student này ra file tên là StudentInformation.txt
		String content = listStudent.toString();

		System.out.println("Nhập vào đường dẫn File để tạo file StudentInformation.txt");
		String path1 = ScannerUltis.inputString();
		FileUltis.createNewFile(path1, "StudentInformation.txt");
		System.out.println("Nhập vào đường dẫn file để viết :");
		String path2 = ScannerUltis.inputString();
		IOManager.writeFile(path2, true, content);
		// đọc thông tin file StudentInformation.txt và in ra màn hình
		System.out.println(IOManager.readFile(path2)); 

	}
}
