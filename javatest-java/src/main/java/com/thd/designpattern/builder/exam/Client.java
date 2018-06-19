package com.thd.designpattern.builder.exam;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Builder builder = new BuildImpl();
		CarDirector carBuilder = new CarDirector(builder);
		Car c = carBuilder.buildCar();
		System.out.println(c.getDoor());
		System.out.println(c.getWheel());
		System.out.println(c.getEngine());
	}

}
