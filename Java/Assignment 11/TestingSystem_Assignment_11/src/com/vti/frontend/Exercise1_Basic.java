package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Exercise1_Basic {
	
	public static void main(String[] args)
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		accountFunction accFunction = new accountFunction();
//		accFunction.menuAccount();
		
		departmentFunction depFunction = new departmentFunction();
		depFunction.menuDepartment();
	}
	
	
	
}
