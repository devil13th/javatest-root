package com.thd.spring.annotation.aop;

import org.springframework.stereotype.Component;


@Component
public class MathService {
	public Integer add(int a,int b){
		return Integer.valueOf(a+b);
	}
	
	public Double div(double a,double b) {
		System.out.println(1/0);
		return Double.valueOf(a/b);
	}
}
