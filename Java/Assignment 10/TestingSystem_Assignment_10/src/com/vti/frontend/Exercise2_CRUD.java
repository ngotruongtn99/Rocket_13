package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.Exercise2;
import com.vti.backend.Exercise2_Q8;

public class Exercise2_CRUD {

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
//		Exercise2 exercise2 = new Exercise2();
//		exercise2.Question8();
		
		Exercise2_Q8 exercise2_Q8 = new Exercise2_Q8();
		exercise2_Q8.question1();
		exercise2_Q8.question6();

	}
}
