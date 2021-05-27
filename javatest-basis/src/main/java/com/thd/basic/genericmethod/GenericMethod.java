package com.thd.basic.genericmethod;

import com.thd.basic.container.Student;

/**
 * com.thd.basic.genericmethod.GenericMethod
 *
 * @author: wanglei62
 * @DATE: 2021/4/22 16:30
 **/
public class GenericMethod {

    /**
     *  <E> : 代表该方法有一个泛型E
     *  E createObj(..)的E: 方法返回值的类型是泛型E
     *
     */
    public static <E> E createObj(String classname) throws Exception{
        return (E)Class.forName(classname).newInstance();
    }

    public static <A,B,C> C getObj(A a,C c) throws Exception{
        return c;
    }

    public <F> F testGenericMethod(F obj) {
        return obj;
    }


    public static void main(String[] args) throws Exception{
        Test t = GenericMethod.createObj("com.thd.basic.genericmethod.Test");
        System.out.println(t);


        Student a = new Student("ss",5);
        Student x = GenericMethod.getObj(t,a);


        // 根据传入的参数类型不同返回不同的类型
        GenericMethod gm = new GenericMethod();
        Test testObj = gm.testGenericMethod(t);
        Student studentObj =  gm.testGenericMethod(a);
    }
}
