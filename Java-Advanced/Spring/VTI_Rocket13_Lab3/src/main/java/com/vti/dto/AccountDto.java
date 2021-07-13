package com.vti.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class AccountDto {
	private short id;
	private String fullname;
	private String department;
	private String position;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	public AccountDto(short id, String fullname, String department, String position, Date createDate) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
	}

	

}
