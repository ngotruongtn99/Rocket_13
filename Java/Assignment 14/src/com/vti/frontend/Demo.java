package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.ultis.ScannerUltis;

public class Demo {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Function function = new Function();
		
		while (true) {
			System.out.format("+---------------------------------------------------------+%n");
			System.out.format("|                           MENU                          |%n");
			System.out.format("+---------------------------------------------------------+%n");
			String leftAlignFormat = "| %-56s|%n";
			System.out.format(leftAlignFormat,"1. ADMIN");
			System.out.format(leftAlignFormat,"2. USER");
			System.out.format(leftAlignFormat,"3. EXIT");
			System.out.format("+---------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				function.loginAdmin();
				break;
			case 2:
				function.loginUser();
				break;
			case 3:
				return;
			default:
				System.out.println("Chọn đúng MENU !!");
				break;
			}
		}
	}

}
