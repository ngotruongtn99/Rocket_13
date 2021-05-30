package com.vti.entity.Ex1.Q1;

public class News implements INews {

	private int id;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private float averageRate;
	private int[] rates;
	
	public int[] getRates() {
		return rates;
	}

	public void setRates(int[] rates) {
		this.rates = rates;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public void disPlay() {
		String leftAlignFormat = "| %-12s ";
		String left1AlignFormat = "| %-11s ";
		String midAlignFormat = "| %-14s";
		String right1AlignFormat = "| %-12s ";
		String rightAlignFormat = "| %-12s |%n";
		System.out.format("+--------------------------------------------------------------------------+%n");
		System.out.format("|                               TIN TỨC                                    |%n");
		System.out.format("+--------------------------------------------------------------------------+%n");
		System.out.format(leftAlignFormat, "TITLE");
		System.out.format(left1AlignFormat, "PUBLISHDATE");
		System.out.format(midAlignFormat, "AUTHOR");
		System.out.format(right1AlignFormat, "CONTENT");
		System.out.format(rightAlignFormat, "AVERAGE RATE");
		System.out.format("+--------------------------------------------------------------------------+%n");
	}

	@Override
	public float calculate() {
		return averageRate = (float) (rates[0] + rates[1] + rates[2]) / 3;
	}

	public float getAverageRate() {
		return averageRate;
	}

}
