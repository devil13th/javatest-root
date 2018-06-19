package com.thd.calendar;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;


public class TestCalendar {
	
	@Test
	//获取当前日期
	public void test01(){
		Calendar dar = Calendar.getInstance();
		System.out.println(dar.get(Calendar.YEAR) + "-" + (dar.get(Calendar.MONTH)+1) + "-" + dar.get(Calendar.DAY_OF_MONTH));
		
		dar.setTime(new Date());
		System.out.println(dar.get(Calendar.YEAR) + "-" + (dar.get(Calendar.MONTH)+1) + "-" + dar.get(Calendar.DAY_OF_MONTH));
	}
	
	@Test
	//制定日期
	public void test02(){
		Calendar dar = Calendar.getInstance();
		dar.set(1984, 5, 25);
		System.out.println(dar.get(Calendar.YEAR) + "-" + (dar.get(Calendar.MONTH)+1) + "-" + dar.get(Calendar.DAY_OF_MONTH));
	}
	
	@Test
	//日期加减法
	public void test03(){
		//加天数
		Calendar dar = Calendar.getInstance();
		dar.add(Calendar.DAY_OF_MONTH, 20);
		System.out.println(dar.get(Calendar.YEAR) + "-" + (dar.get(Calendar.MONTH)+1) + "-" + dar.get(Calendar.DAY_OF_MONTH));
		
		//减天数
		Calendar dar1 = Calendar.getInstance();
		dar1.add(Calendar.DAY_OF_MONTH, -20);
		System.out.println(dar1.get(Calendar.YEAR) + "-" + (dar1.get(Calendar.MONTH)+1) + "-" + dar1.get(Calendar.DAY_OF_MONTH));
		
		//加年数
		Calendar dar2 = Calendar.getInstance();
		dar2.add(Calendar.YEAR, -1);
		System.out.println(dar2.get(Calendar.YEAR) + "-" + (dar2.get(Calendar.MONTH)+1) + "-" + dar2.get(Calendar.DAY_OF_MONTH));
		
		
	}
}
