package com.thd.basic.genericmethod;

/**
 * com.thd.basic.genericmethod.GenericMethod
 *
 * @author: wanglei62
 * @DATE: 2021/4/22 16:30
 **/
public class GenericMethod {

    public static <E> E createObj(String classname) throws Exception{
        return (E)Class.forName(classname).newInstance();
    }


    public static void main(String[] args) throws Exception{
        Test t = GenericMethod.createObj("com.thd.basic.genericmethod.Test");
        System.out.println(t);
    }
}
