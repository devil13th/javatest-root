package com.thd.basic.lambda.test01;

public class MyInterfaceImpl implements  MyInterface {
    @Override
    public String hello(String name) {
        return String.format("hello %s",name);
    }

//    @Override
//    public String bey(String name) {
//        return String.format("bey %s",name);
//    }
}
