package com.vti.entity.Ex1;

import java.util.Scanner;

public abstract  class CanBo {
	protected String hoTen;
	protected int tuoi;
	protected GioiTinh gioiTinh;
	protected String diaChi;

	public CanBo(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi) {
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
	}

	public CanBo() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Mời bạn nhập vào họ tên: ");
		hoTen = scanner.nextLine();
		System.out.print("Mời bạn nhập vào tuổi: ");
		tuoi = scanner.nextInt();
		System.out.print("Mời bạn nhập vào giới tính (1: Nam, 2: Nu, 3: KhongBiet) ");
		int gtinh = scanner.nextInt();
		switch (gtinh) {
		case 1:
			this.gioiTinh = GioiTinh.NAM;
			break;
		case 2:
			this.gioiTinh = GioiTinh.NU;
			break;
		case 3:
			this.gioiTinh = GioiTinh.KHONGBIET;
			break;
		}

	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public GioiTinh getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(GioiTinh gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "CanBo [hoTen=" + hoTen + ", tuoi=" + tuoi + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + "]";
	}

}
