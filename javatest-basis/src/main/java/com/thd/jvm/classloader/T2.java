package com.thd.jvm.classloader;

import java.lang.reflect.Method;


public class T2 {

	public static void main(String []args) throws Exception{
        /*
		System.out.println(T.class.getClassLoader().toString());
        System.out.println(T.class.getClassLoader().getParent().toString());
        System.out.println(T.class.getClassLoader().getParent().getParent().toString());
		
		//输出结果：
		sun.misc.Launcher$AppClassLoader@73d16e93
		Exception in thread "main" sun.misc.Launcher$ExtClassLoader@15db9742
		java.lang.NullPointerException
		at com.thd.test.jvm.T.main(T.java:12)
		 */
        
		
		
		/**
		 * 操作说明
		 * 1.d盘创建文件夹D:\com\thd\jvm\classloader
		 * 2.将MyBean.java编译后的MyBean.class文件拷贝到步骤1创建的文件夹中
		 * 3.执行此类
		 */
		
		
		
		//自定义类加载器的加载路径
        MyClassLoader myClassLoader=new MyClassLoader("D:\\deleteme");
        Class c = null;
        try {
			c = myClassLoader.findClass("com.thd.jvm.classloader.MyBean");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        if(c!=null){
            Object obj=c.newInstance();
            Method method=c.getMethod("say", null);
            method.invoke(obj, null);
        }
        
        
        
        
        //使用自定义的类加载器加载
        MyBean mb = new MyBean();
        System.out.println(mb.getClass().getClassLoader());
        mb.say();
    }

}
