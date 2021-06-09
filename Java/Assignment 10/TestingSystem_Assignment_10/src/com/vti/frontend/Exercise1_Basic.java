package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.Exercise1;

public class Exercise1_Basic {

	public static void main(String[] args)
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Exercise1 exercise1 = new Exercise1();
		exercise1.Question1();
		
		exercise1.Question2();
//		exercise1.Question3();
//		exercise1.Question4();
		exercise1.Question5();
	}

}
