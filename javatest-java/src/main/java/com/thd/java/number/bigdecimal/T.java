package com.thd.java.number.bigdecimal;

import java.math.BigDecimal;

public class T {
	public static void main(String[] args){
		BigDecimal bd1 = new BigDecimal("5.001");
		System.out.println(bd1.intValue());
		try{
			System.out.println(bd1.intValueExact());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		BigDecimal bd2 = new BigDecimal("5.00001");
		System.out.println(bd2.floatValue());
		try{
			System.out.println(bd2.floatValue());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}
}
