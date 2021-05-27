package com.vti.entity.Ex1;

public class Position {
	private int id;
	private PositionName name;
	private enum PositionName {
	DEV, TEST, SCRUM_MASTER, PM
	}
	
	public Position() {
		super();
	}

	public Position(int id, PositionName name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PositionName getName() {
		return name;
	}

	public void setName(PositionName name) {
		this.name = name;
	}
	
}
