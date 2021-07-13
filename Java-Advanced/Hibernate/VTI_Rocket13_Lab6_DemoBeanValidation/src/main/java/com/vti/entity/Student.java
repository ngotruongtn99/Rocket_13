package com.vti.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class Student {
	
	@Min(value = 1, message = "ID không hợp lệ !")
	private int id;
	
	@Length(min = 6, max = 12, message = "Tên không hợp lệ !")
	private String name;
	
	@Email(message = "Email không hợp lệ !")
	private String email;
	
	@Min(value = 18, message = "Tuổi không hợp lệ !")
	private int age;
}
