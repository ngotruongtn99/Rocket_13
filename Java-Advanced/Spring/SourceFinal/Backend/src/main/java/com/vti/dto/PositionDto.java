package com.vti.dto;

public class PositionDto {

	private short id;
	
	private String name;

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PositionDto(short id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
