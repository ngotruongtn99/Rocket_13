package com.vti.entity.Ex4;

public class Circle {
	private double radius;
	private String color;
	
	public Circle() {
		super();
	}

	public Circle(Double radius) {
		super();
		this.radius = radius;
	}

	public Circle(Double radius, String color) {
		super();
		this.radius = radius;
		this.color = color;
	}

	public static final Double PI = 3.14;
	
	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public Double getArea() {
		return PI * Math.pow(this.radius, 2.0);
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", color=" + color + "]";
	}
}
