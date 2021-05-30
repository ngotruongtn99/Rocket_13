package com.vti.entity.Ex1.Q2;

public class KhoiThi {
	
	private String name;
	private String subject;
	
	public KhoiThi(String name) {
		super();
		this.name = name;
		this.subject = subject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		switch (this.name) {
		case "A":
			this.subject = "Toán, Lý, Hóa";
			break;
		case "a":
			this.subject = "Toán, Lý, Hóa";
			break;

		case "B":
			this.subject = "Toán, Sinh, Hóa";
			break;
		case "b":
			this.subject = "Toán, Sinh, Hóa";
			break;
			
		case "C":
			this.subject = "Văn, Sử, Địa";
		case "c":
			this.subject = "Văn, Sử, Địa";
		}
		return subject;
	}
	
}
