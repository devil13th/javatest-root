package com.thd.basic.lambda.test01;

import junit.framework.TestCase;
import org.junit.Test;

public class Test01 extends TestCase {
    /**
     * lambda表达式 箭头函数
     * 当接口只有一个方法的时候可以使用lambda表达式的箭头函数
     */
    @Test
    public void test01(){

        MyInterfaceService s = new MyInterfaceService();
        s.sayHello(new MyInterface() {
            @Override
            public String hello(String name) {
                return String.format("hellos %s",name);
            }

//            @Override
//            public String bey(String name) {
//                return String.format("beys %s",name);
//            }
        });

        //当接口只有一个方法的时候可以使用lambda表达式的箭头函数
        s.sayHello((x)->{return String.format("hi %s",x);});

        System.out.println(" ---- ");
        MyInterface mi2 = new MyInterfaceImpl();
        s.sayHello(mi2::hello);

        Runnable runnable = () -> {System.out.println("lambda 表达式");};

        new Thread(runnable).start();

        new Thread( () -> {System.out.println("lambda 表达式2");});
        System.out.println(1234);



        //========= 函数接口用下面几种方式定义
        MyInterface exam01 = name -> "Hello" + name;
        MyInterface exam02 = (name) -> "Hello" + name;
        MyInterface exam03 = (String name) -> "Hello" + name;

        MyInterface exam04 = (name) -> name.trim();
        MyInterface exam05 = String::trim;
        String x = exam05.hello("  aaa ");
        System.out.println(x);
    }
}
