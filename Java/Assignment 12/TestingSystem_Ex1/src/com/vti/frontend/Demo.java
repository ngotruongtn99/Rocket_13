package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.ultis.ScannerUltis;

public class Demo {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Function function = new Function();
		while (true) {
			System.out.format("+--------------------------------------------------------------+%n");
			System.out.format("|                        CHOOSE PLEASE                         |%n");
			System.out.format("+--------------------------------------------------------------+%n");
			String leftAlignFormat = "|%-62s| %n";
			System.out.format(leftAlignFormat,"1. LOGIN");
			System.out.format(leftAlignFormat, "2. REGISTER");
			System.out.format(leftAlignFormat, "3. EXIT");
			System.out.format("+--------------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				function.getLogin();
				break;
			case 2:
				function.getRegister();
				break;
			case 3:
				
				return;
			default:
				System.out.println("Mời chọn lại !");
				break;
			}
		}
		
	}
}
