package com.thd.basic.lambda.test01;

public class MyInterfaceService {
    public void sayHello(MyInterface mi){
        String str = mi.hello("devil13th");
        System.out.println(str);
    };
}
