package com.vti.entity.Ex2.Q4;

public class MyMath {
	
	public int sum(int a, int b) {
		System.out.print("Tổng của 2 số kiểu int là: ");
		return a+b;
	}
	
	public float sum(float a, float b) {
		System.out.print("Tổng của 2 số kiểu float là: ");
		return (float) a+b;
	}
	
	public byte sum(byte a, byte b) {
		System.out.print("Tổng của 2 số kiểu byte là: ");
		return (byte) (a+b);
	}
}
