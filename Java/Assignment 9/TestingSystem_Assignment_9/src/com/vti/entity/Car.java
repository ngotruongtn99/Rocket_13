package com.vti.entity;

public class Car {
	private String name;
	private String type;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Car(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public class Engine {
		private String engineType;

		public String getEngineType() {
			return engineType;
		}

		public Engine(String engineType) {
			super();
			this.engineType = engineType;
		}

		public void setEngineType(String engineType) {
			this.engineType = engineType;
		}
		
	}
}
