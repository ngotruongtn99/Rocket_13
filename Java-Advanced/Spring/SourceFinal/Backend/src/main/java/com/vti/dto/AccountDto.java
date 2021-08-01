package com.vti.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class AccountDto {
	private short id;
	private String email;
	private String username;
	private String fullname;
	private String department;
	private String position;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	public AccountDto(short id, String email, String username, String fullname, String department, String position,
			Date createDate) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
	}
	public AccountDto(String fullname) {
		super();
		this.fullname = fullname;
	}
	

	

}
