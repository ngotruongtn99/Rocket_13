package com.vti.entity.Ex1;

import java.util.ArrayList;
import java.util.Scanner;


public class QLCB {
	private ArrayList<CanBo> canBos;
	private Scanner scanner;

	public QLCB() {
		canBos = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	public QLCB(ArrayList<CanBo> canBos) {
		this.canBos = canBos;
	}

	public void addCanBo() {
		System.out.print("Bạn muốn  thêm bao nhiêu cán bộ ? ");
		int x = scanner.nextInt();
		for (int i = 0; i < x; i++) {
			System.out.print("Bạn muốn thêm Nhân viên (nhập vào 1), Công nhân (nhập vào 2), Kỹ sư (nhập vào 3): ");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
				NhanVien nhanVien = new NhanVien();
				break;
			case 2:
				CongNhan congNhan = new CongNhan();
				break;
			case 3:
				KySu kySu = new KySu();				
				break;
			}
			System.out.println("Nhập thành công cán bộ " + (i + 1));
		}
	}

	public void findByName() {
		// TODO
		System.out.println("findByName");
	}

	public void printListCanBo() {
		for (int i = 0; i < canBos.size(); i++) {
			System.out.println("Thông tin cán bộ " + (i + 1) + " là : ");
		}
		System.out.println("----------------------------");
	}

	public void deleteCanBo(String name) {
		// TODO
		System.out.println("deleteCanBo");
	}

	public void deleteCanBo() {

		String inputName = scanner.nextLine();
		deleteCanBo(inputName);
	}

}
