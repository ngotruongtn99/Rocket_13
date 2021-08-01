package com.vti.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DepartmentDto {
	private short id;
	
	private String name;

	private AccountDto authorName;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	

	public AccountDto getAuthorName() {
		return authorName;
	}

	public Date getCreateDate() {
		return createDate;
	}




	public DepartmentDto(short id, String name, AccountDto authorName, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.authorName = authorName;
		this.createDate = createDate;
	}

	public short getId() {
		return id;
	}

	

	public String getName() {
		return name;
	}

	
}
