package com.thd.reflection.advance;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyBeanUtils {
	
	/**
	 * @description copy original object's properties that not null to destination object
	 * @param dest destination objet
	 * @param orig original object 
	 * @throws Exception 
	 */
	public static void copyNotNullProperties(Object dest,Object orig) throws Exception{
		if(orig.getClass() != dest.getClass()){
			throw new Exception("源对象和目的对象不是同一类型!");
		}
		Field[] fields = dest.getClass().getDeclaredFields();
		for(int i = 0 , j = fields.length ; i < j ; i++){
			System.out.println(fields[i].getName());
			String fieldName = fields[i].getName();
			String setter = "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1,fieldName.length());
			String getter = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1,fieldName.length());
			Method setterMethod = dest.getClass().getMethod(setter, fields[i].getType());
			Method getterMethod = orig.getClass().getMethod(getter, null);
			if(getterMethod.invoke(orig, null) != null){
				setterMethod.invoke(dest, getterMethod.invoke(orig, null));			
			}
		}
	}
	
	
	public static void setObjNullProperties(Object obj,String[] properties) throws Exception{
		if(properties!= null && properties.length != 0){
			for(String property : properties){
				property = property.trim();
				Field field = obj.getClass().getDeclaredField(property);
				String setter = "set" + property.substring(0,1).toUpperCase() + property.substring(1,property.length());
				Method setterMethod = obj.getClass().getMethod(setter, field.getType());
				setterMethod.invoke(obj,new Object[]{null});
			}
		}
	}
	
}
