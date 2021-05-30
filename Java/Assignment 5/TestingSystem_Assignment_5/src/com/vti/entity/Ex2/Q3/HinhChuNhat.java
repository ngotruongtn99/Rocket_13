package com.vti.entity.Ex2.Q3;

public class HinhChuNhat implements PhepToan {
	private int chieuDai;
	private int chieuRong;

	
	public HinhChuNhat(int chieuDai, int chieuRong) {
		super();
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}
	public int chuVi() {
	
		return (this.chieuDai + this.chieuRong) * 2;
	}
	public int dienTich() {

		return this.chieuDai * this.chieuRong;
	}

}
