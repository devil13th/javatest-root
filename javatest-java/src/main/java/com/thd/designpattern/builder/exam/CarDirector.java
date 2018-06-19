package com.thd.designpattern.builder.exam;

public class CarDirector {
	private Builder builder;
	
	public CarDirector(Builder builder){
		this.builder = builder;
	}
	
	public Car buildCar(){
		builder.buildDoor();
		builder.buildEngine();
		builder.buildWheel();
		Car c = builder.buildCar();
		return c;
	}
}
