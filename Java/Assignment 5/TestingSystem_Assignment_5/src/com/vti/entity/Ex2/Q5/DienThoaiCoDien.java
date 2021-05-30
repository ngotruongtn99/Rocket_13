package com.vti.entity.Ex2.Q5;

public class DienThoaiCoDien extends DienThoaiDiDong {

	@Override
	public void nghe() {
		
		super.nghe();
		System.out.println("Loa hơi rè, nói to lên ...");
	}

	@Override
	public void tanCong() {
		super.tanCong();
		System.out.println("Đáp là to đầu .. ");
	}

	@Override
	public void goi() {
		
		super.goi();
		System.out.println("Đang gọi mất sóng ....");
	}

	@Override
	public void guiTinNhan() {
		
		super.guiTinNhan();
		System.out.println("Đăng kí gói 3000đ 100 tin nội mạng");
	}

	@Override
	public void nhanTinNhan() {
		
		super.nhanTinNhan();
		System.out.println("Đăng kí gói 3000đ 100 tin nội mạng");
	}
	
}
