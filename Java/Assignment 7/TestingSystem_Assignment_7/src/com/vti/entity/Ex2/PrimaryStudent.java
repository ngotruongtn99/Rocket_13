package com.vti.entity.Ex2;

import com.vti.ultis.ScannerUltis;

public final class PrimaryStudent extends Student {
	
	
	public PrimaryStudent() {
		super();
		System.out.print("PrimaryStudent Name: ");
		String nameSt = ScannerUltis.inputString();
		this.setName(nameSt);
		
		
		
	}
	
	public final void PrimaryStudentStudy() {
		System.out.println("PrimaryStudent " + getName() + " đang học bài");
	}

}
