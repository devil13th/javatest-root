package com.thd.java.number.decimalformat;

import java.text.DecimalFormat;

public class T {
	public static void main(String[] args){
		double n = 1125.12345678;
		/**
		 * 0  代表数字
		 * # 代表非0数字
		 */
		DecimalFormat a = new DecimalFormat("0000.0000000");
		System.out.println("00000.0000000");
		System.out.println(a.format(n));
		System.out.println("===================================");
		
		a = new DecimalFormat("#####.0000000");
		System.out.println(a.format(n));
		System.out.println("===================================");
		
		a = new DecimalFormat("##,###.0000000");
		System.out.println(a.format(n));
		System.out.println("===================================");
	}
}
