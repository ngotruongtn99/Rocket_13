package com.vti.entity;

public class CategoryQuestion {
	public int id;
	public CategoryName name;
	
	public enum CategoryName {
		JAVA, DOT_NET, SQL, POSTMAN, RUBY
	}
}
