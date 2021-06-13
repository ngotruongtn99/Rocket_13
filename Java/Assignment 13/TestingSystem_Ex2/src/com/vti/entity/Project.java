package com.vti.entity;

public class Project {
	private int id;
	private String name;
	private int teamsize;
	
	public Project(int id,String name, int teamsize) {
		this.id = id;
		this.name = name;
		this.teamsize = teamsize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeamsize() {
		return teamsize;
	}

	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}
	
}
