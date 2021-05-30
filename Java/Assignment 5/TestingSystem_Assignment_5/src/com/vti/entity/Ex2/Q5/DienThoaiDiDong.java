package com.vti.entity.Ex2.Q5;

public abstract class DienThoaiDiDong implements ITanCong {
	public void nghe() {
		System.out.println("Đang nghe .....");
	}
	
	@Override
	public void tanCong() {
		
	}

	public void goi() {
		System.out.println("Đang gọi .....");
	}
	
	public void guiTinNhan() {
		System.out.println("Đang gửi tin nhắn.....");
	}
	
	public void nhanTinNhan() {
		System.out.println("Tin nhắn đến .....");
	}
}
