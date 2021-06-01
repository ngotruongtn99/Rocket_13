package com.vti.frontend;

import com.vti.backend.Exercise1;
import com.vti.entity.Ex1.MyMath;
import com.vti.entity.Ex1.Student;

public class Exercise1_Static {

	public static void main(String[] args) {
//		Exercise1 exercise1 = new Exercise1();
//		exercise1.Question1();
		
		//Question 3
		
		System.out.println("Tổng 2 số 4 và 5 là: " + MyMath.sum(4, 5));
		System.out.println("Min giữa 2 số 4 và 5 là: " + MyMath.min(4, 5));
		System.out.println("Max giữa 2 số 4 và 5 là: " + MyMath.max(4, 5));
		
		//Question 4
		Student.changeCollege();
		Student.showCollege();
		
	}
	

}
