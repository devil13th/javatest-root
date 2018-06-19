package com.thd.reflection.advance;

import java.lang.reflect.Field;


public class T {

	public static void main(String[] args) throws Exception {
		Person grandson = new Person();
		grandson.setName("孙子");
		Person son = new Person();
		son.setName("儿子");
		son.setSon(grandson);
		Person p = new Person();
		p.setName("我");
		p.setSon(son);
		
		Person copyPerson = new Person();
		copyPerson.setAge(5);
		Class c = p.getClass();
		Field[] pubFS = c.getFields();
//		for(int i = 0 , j = pubFS.length ; i < j ; i++){
//			System.out.println(pubFS[i].getName());
//		}
//		System.out.println("----");
		Field[] fs = c.getDeclaredFields();
//		for(int i = 0 , j = fs.length ; i < j ; i++){
//			//System.out.println(fs[i].getName());
//			//System.out.println(fs[i].getType().getName());
//			String setter = "set" + fs[i].getName().substring(0,1).toUpperCase() + fs[i].getName().substring(1,fs[i].getName().length());
//			String getter = "get" + fs[i].getName().substring(0,1).toUpperCase() + fs[i].getName().substring(1,fs[i].getName().length());
//			Method method = c.getMethod(getter, null);
//			Object obj = method.invoke(p, null);
//			System.out.println(obj);
//			if(obj != null){
//				BeanUtils.copyProperty(copyPerson, fs[i].getName(), obj);
//			}
//		}
		
		
//		System.out.println("------------");
//		Field[] fss = c.getDeclaredFields();
//		for(int i = 0 , j = fss.length ; i < j ; i++){
//			String getter = "get" + fs[i].getName().substring(0,1).toUpperCase() + fs[i].getName().substring(1,fs[i].getName().length());
//			Method method = c.getMethod(getter, null);
//			Object obj = method.invoke(p, null);
//			System.out.println(obj);
//		}
		
//		MyBeanUtils.copyNotNullProperties(p, copyPerson);
//		System.out.println("=====================");
//		System.out.println(p.getName());
//		System.out.println(p.getAge());
//		System.out.println(p.getSon());
		p.setAge(5);
		System.out.println(p.getName());
		System.out.println(p.getAge());
		MyBeanUtils.setObjNullProperties(p,new String[]{"name","age"});
		System.out.println(p.getName());
		System.out.println(p.getAge());
		
	}

}
