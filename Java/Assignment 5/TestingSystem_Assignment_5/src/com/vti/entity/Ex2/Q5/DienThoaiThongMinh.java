package com.vti.entity.Ex2.Q5;

public class DienThoaiThongMinh extends DienThoaiDiDong {
	public void suDung3G() {
		System.out.println("Đang lướt Facebook.....");
	}
	public void chupAnh() {
		System.out.println("Đang Selfie ....");
	}
	@Override
	public void tanCong() {
		super.tanCong();
		System.out.println("Đáp là hỏng máy :(((");
		
	}
	@Override
	public void nghe() {
		super.nghe();
		System.out.println("Đang nghe qua Airpod Pro");
	}
	@Override
	public void goi() {
		super.goi();
		System.out.println("Đang gọi Facetime cho NY");
		
	}
	@Override
	public void guiTinNhan() {
		super.guiTinNhan();
		System.out.println("Đang nhắn tin trên Zalo");
	}
	@Override
	public void nhanTinNhan() {
		super.nhanTinNhan();
		System.out.println("Đang nhận tin nhắn qua IMessenger");
	}
}
