package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Ex1.Q1.News;

public class Exercise1 {
	private Scanner sc;
	ArrayList<News> newsArr = new ArrayList<News>();

	public Exercise1() {
		sc = new Scanner(System.in);

	}

	public void insertNews() {
		int[] intNum = new int[3];
		News news1 = new News();
		System.out.println("Nhập vào Title của News");
		news1.setTitle(sc.nextLine());
		System.out.println("Nhập vào PublishDate của News");
		news1.setPublishDate(sc.nextLine());
		System.out.println("Nhập vào Author của News");
		news1.setAuthor(sc.nextLine());
		System.out.println("Nhập vào Content của News");
		news1.setContent(sc.nextLine());
		for (int i = 0; i < 3; i++) {
			System.out.println("Nhập điểm đánh giá thứ " + (i + 1) + " của News");
			intNum[i] = sc.nextInt();
		}
		newsArr.add(news1);
		news1.setRates(intNum);
	}

	public void disPlayNews() {

		for (News news : newsArr) {
			news.disPlay();
			String leftAlignFormat = "| %-12s ";
			String left1AlignFormat = "| %-11s ";
			String midAlignFormat = "| %-14s";
			String right1AlignFormat = "| %-12s ";
			String rightAlignFormat = "| %-12s |%n";
			System.out.format(leftAlignFormat, news.getTitle());
			System.out.format(left1AlignFormat, news.getPublishDate());
			System.out.format(midAlignFormat, news.getAuthor());
			System.out.format(right1AlignFormat, news.getContent());
			System.out.format(rightAlignFormat, news.calculate());

		}
		System.out.format("+--------------------------------------------------------------------------+%n");
	}

	public void averageRate() {
		for (News news : newsArr) {
			System.out.println("Title: " + news.getTitle() + " Average Rate: " + news.calculate());

		}
	}
}
