package com.vti.backend;

import com.vti.entity.CPU;
import com.vti.entity.Car;

public class Exercise3 {
	public void Question1() {
		CPU cpu1 = new CPU((float) 5.6);
		CPU.Processor Pro1 = cpu1.new Processor(4, "Intel");
		CPU.Ram ram1 = cpu1.new Ram(8, "Kingston");
		
		System.out.println("In thông tim Processor:");
		System.out.println("Cache Processor: " + Pro1.getCache());
		System.out.println("Clock Speed Ram: " + ram1.getClockSpeed());
	}
	
	public void Question2() {
		Car car1 = new Car("Mazda", "8WD");
		Car.Engine eng1 = car1.new Engine("Crysler");
		System.out.println("Loại xe: " + car1.getName() +" " + car1.getType());
		System.out.println("Thông tin động cơ: " + eng1.getEngineType());
		
	}
}
