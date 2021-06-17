package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;


public class Demo {

	public static void main(String[] args)
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		accountFunction accountFunction = new accountFunction();
		while (true) {
			System.out.println("------MỜI BẠN LOGIN------");
			if (accountFunction.islogin()) {
				accountFunction.Menu();
			} else {
				System.out.println("Đã có lỗi xảy ra");
			}
		}
		
	}

}
