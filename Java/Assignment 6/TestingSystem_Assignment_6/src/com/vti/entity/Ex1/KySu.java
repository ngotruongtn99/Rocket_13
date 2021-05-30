package com.vti.entity.Ex1;

import java.util.Scanner;

public class KySu extends CanBo {
	private String nganhDaoTao;

	public KySu(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi, String nganhDaoTao) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.nganhDaoTao = nganhDaoTao;
	}
	public KySu() {
		super();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập ngành đào tạo:");
		this.nganhDaoTao = sc.next();
	}
	public String getNganhDaoTao() {
		return nganhDaoTao;
	}

	public void setNganhDaoTao(String nganhDaoTao) {
		this.nganhDaoTao = nganhDaoTao;
	}

}
