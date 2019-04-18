package com.thd.jvm.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class T {

	public static void main(String []args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
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
        MyClassLoader myClassLoader=new MyClassLoader("D:\\");
        //使用自定义的类加载器加载
        //包名+类名
        Class c=myClassLoader.loadClass("com.thd.jvm.classloader.MyBean");
        
        //使用自定义的类加载器加载MyBean2,
        //但是MyBean2没有在D盘下,也可以加载到,是因为双亲委派机制
        //当自定义的类加载器加载某类的时候会先为派给其父类加载,父类是AppClassLoader,
        //AppClassLoader类加载器是加载classpath下的类,可以找到所以返回了MyBean2的class
        Class c2 = Class.forName("com.thd.jvm.classloader.MyBean2",true,myClassLoader);
        
        
        //下面的代码是使用AppClassLoader类加载器加载MyBean2
        //Class c2 = Class.forName("com.thd.jvm.classloader.MyBean2",true,myClassLoader);
        
        System.out.println("com.thd.jvm.classloader.MyBean的classloader是" + c.getClassLoader());
        //虽然使用myClassLoader加载的MyBean2,但因为双亲委派机制,真实加载到MyBean2的classloader是MyClassLoader
        System.out.println("com.thd.jvm.classloader.MyBean2的classloader是" + c2.getClassLoader());
        System.out.println(c2);
        if(c!=null){
            Object obj=c.newInstance();
            Method method=c.getMethod("say", null);
            method.invoke(obj, null);
        }
        
        
        
        /**
         * 结果：
com.thd.jvm.classloader.MyBean的classloader是com.thd.jvm.classloader.MyClassLoader@2503dbd3
com.thd.jvm.classloader.MyBean2的classloader是sun.misc.Launcher$AppClassLoader@73d16e93
class com.thd.jvm.classloader.MyBean2
Hello MyClassLoader

         */
    }

}
