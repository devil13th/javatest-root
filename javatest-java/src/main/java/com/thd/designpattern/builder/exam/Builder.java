package com.thd.designpattern.builder.exam;

public interface Builder {
	public Car buildCar();
	public void buildDoor();
	public void buildEngine();
	public void buildWheel();
}
