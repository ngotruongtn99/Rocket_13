package com.vti.entity.Ex1;

import java.sql.Date;
import java.time.LocalDate;

public class Exam {
	public int id;
	public String code;
	public String title;
	public CategoryQuestion category;
	public int duration;
	public Account account;
	public Date  createDate;
	public Question[] questions;
}
