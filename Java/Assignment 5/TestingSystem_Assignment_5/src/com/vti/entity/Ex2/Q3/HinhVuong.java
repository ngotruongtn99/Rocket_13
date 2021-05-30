package com.vti.entity.Ex2.Q3;

public class HinhVuong extends HinhChuNhat{
	
	public HinhVuong(int chieuDai) {
		super(chieuDai, chieuDai);
	}

	@Override
	public int chuVi() {
		System.out.println("Chu vi Hình Vuông là: ");
		return super.chuVi();
	}

	@Override
	public int dienTich() {
		System.out.println("Diện  tích Hình Vuông là: ");
		return super.dienTich();
	}
	
}
