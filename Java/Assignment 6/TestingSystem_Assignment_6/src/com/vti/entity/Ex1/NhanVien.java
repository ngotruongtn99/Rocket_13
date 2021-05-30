package com.vti.entity.Ex1;

import java.util.Scanner;

public class NhanVien extends CanBo  {
	private String congViec;

	public NhanVien(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi, String congViec) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.congViec = congViec;
	}

	public NhanVien() {
		super();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào công việc");
		this.congViec = sc.next();
	}
	public String getCongViec() {
		return congViec;
	}

	public void setCongViec(String congViec) {
		this.congViec = congViec;
	}

}
