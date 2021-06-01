package com.vti.entity.Ex2;

import com.vti.ultis.ScannerUltis;

public final class SecondaryStudent extends Student {

	public SecondaryStudent() {
		super();
		System.out.print("SecondaryStudent Name: ");
		String nameSt = ScannerUltis.inputString();
		this.setName(nameSt);
		
	}
	public final void SecondaryStudentStudy() {
		System.out.println("SecondaryStudent " + getName() + " đang học bài");
	}

}
