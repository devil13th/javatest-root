package com.thd.designpattern.builder.exam;

public class BuildImpl implements Builder {
	
	private Car car;
	
	public BuildImpl(){
		car = new Car();
	}
	
	public Car buildCar() {
		return car;
	}

	public void buildDoor() {
		System.out.println("创建车门");
		car.setDoor("车门");

	}

	public void buildEngine() {
		System.out.println("创建引擎");
		car.setEngine("车引擎");

	}

	public void buildWheel() {
		System.out.println("创建轮子");
		car.setWheel("车轮子");
	}

}
