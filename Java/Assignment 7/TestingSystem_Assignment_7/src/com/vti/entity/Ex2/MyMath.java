package com.vti.entity.Ex2;

import com.vti.ultis.ScannerUltis;

public class MyMath {
	public final float pi = (float) 3.14;
	
	public void sum() {
		System.out.println("Nhập vào số a");
		int a = ScannerUltis.inputInt();
		float b = a + pi;
		System.out.println("Tổng a và Pi là: " + b);
		
	}
	
}
