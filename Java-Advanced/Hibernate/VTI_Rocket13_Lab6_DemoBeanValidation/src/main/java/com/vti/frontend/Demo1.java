package com.vti.frontend;

import java.util.Scanner;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.cfg.context.Constrainable;

import com.vti.entity.Student;

public class Demo1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		
		System.out.println("Chương trình quản lý sinh viên");
		
		System.out.println("Nhập vào ID");
		student.setId(sc.nextInt());
		
		System.out.println("Nhập vào Name ");
		student.setName(sc.next());
		
		System.out.println("Nhập vào Email");
		student.setEmail(sc.next());
		
		System.out.println("Nhập vào Age");
		student.setAge(sc.nextInt());
		
		//Thực hiện validate --->
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		
		Set<ConstraintViolation<Student>>violations = validator.validate(student);
		
		if (violations == null  || violations.size() == 0) {
			System.out.println("Thông tin Sinh viên là : " + student.toString());
		} else {
			for (ConstraintViolation<Student> constraintViolation : violations) {
				System.out.println(constraintViolation.getMessage());
			}
		}
	}

}
