package com.thd.java.number;

import java.util.StringTokenizer;


public class T {

	public static void main(String[] args){
		
		// =========== short  =============//
		//最大值为2的15次方-1  32767
		short shortMax = Short.MAX_VALUE;
		//最小值为-2的15次方  -32768
		short shortMin = Short.MIN_VALUE;
		
		// =========== int  =============//
		//最大值为2的31次方-1  2147483647
		int intMax = Integer.MAX_VALUE;
		//最小值为-2的31次方   -2147483648
		int intMin = Integer.MIN_VALUE;
		
		// =========== long  =============//
		//最大值为2的63次方-1  9223372036854775807
		long longMax = Long.MAX_VALUE;
		//最小值为-2的63次方  -9223372036854775808
		long longMin = Long.MIN_VALUE;
		
		// =========== float  =============//
		//最大值为2的128次方-1  3.4028235E38
		float floatMax = Float.MAX_VALUE;
		//最小值为2的-149次方  1.4E-45 
		float floatMin = Float.MIN_VALUE;
		
		// =========== double  =============//
		//最大值为2的1024次方-1  1.7976931348623157E308 
		double doubleMax = Double.MAX_VALUE;
		//最小值为2的-1074次方  4.9E-324
		double doubleMin = Double.MIN_VALUE;
		
		System.out.println(shortMax);
		System.out.println(shortMin);
		System.out.println(intMax);
		System.out.println(intMin);
		System.out.println(longMax);
		System.out.println(longMin);
		System.out.println(floatMax);
		System.out.println(floatMin);
		System.out.println(doubleMax);
		System.out.println(doubleMin);
		
		System.out.println("============================");
		double a = 0.05;
		double b = 0.01;
		System.out.println(a+b);
		
		
		System.out.println(0.05+0.01);  
        System.out.println(1.0-0.42);  
        System.out.println(4.015*100);  
        System.out.println(123.3/100);
        System.out.println("============================");
        
        System.out.println(DoubleUtil.add(a, b)); 
        System.out.println(DoubleUtil.sub(1.0, 0.42));
        System.out.println(DoubleUtil.mul(4.015, 100));
        System.out.println(DoubleUtil.div(123.3, 100));
        
	}
   

}
