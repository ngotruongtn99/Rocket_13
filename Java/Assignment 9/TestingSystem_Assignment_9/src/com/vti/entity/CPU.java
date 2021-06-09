package com.vti.entity;

public class CPU {
	private float price;

	public CPU(float price) {
		super();
		this.price = price;
	}
	
	public class Processor {
		private int coreAmount;
		private String menufacturer;
		
		public Processor(int coreAmount, String menufacturer) {
			super();
			this.coreAmount = coreAmount;
			this.menufacturer = menufacturer;
			}
		
		public Double getCache() {
			return 4.3;
		}
	}
	
	public class Ram {
		private int memory;
		private String menufacturer;
		
		public Double getClockSpeed() {
			return 5.5;
		}

		public Ram(int memory, String menufacturer) {
			super();
			this.memory = memory;
			this.menufacturer = menufacturer;
		}
		
	}
	
}
