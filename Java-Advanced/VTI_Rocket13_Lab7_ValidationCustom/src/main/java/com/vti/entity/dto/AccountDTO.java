package com.vti.entity.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import com.vti.datalayer.DepartmentRepository;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.validation.CheckDepartmentExists;
import com.vti.validation.CheckEmailNotExists;

import lombok.Data;
@Data
public class AccountDTO {

	@NotBlank(message = "Email không được để trống !")
	@Length(min = 6, max = 50, message = "Độ dài Email không hợp lệ !")
	@Email(message = "Email không hợp lệ !")
	@CheckEmailNotExists(message = "Email này đã có trên hệ thống, vui lòng chọn Email khác !	")
	private String email;
	
	@NotBlank(message = "Username không được để trống !")
	@Length(min = 6 , max = 50, message = "Độ dài Username không hợp lệ !")
	private String username;
	
	@NotBlank(message = "Username không được để trống !")
	@Length(min = 6 , max = 50, message = "Độ dài Username không hợp lệ !")
	private String fullname;
	
	@Positive(message = "Nhập số dương !")
	@CheckDepartmentExists
	private int departmentID;

	public AccountDTO(String email,String username, String fullname) {
		super();
		this.email = email;
		this.username = username;
		this.fullname = fullname;
	}
	
	public AccountDTO() {
		// TODO Auto-generated constructor stub
	}

	public Account toEntity() {
		DepartmentRepository depRepository = new DepartmentRepository();
		Department department = depRepository.getDepartmentById((short) departmentID);
		
		return new Account(email, username, fullname, department);
	}
	
	
}
