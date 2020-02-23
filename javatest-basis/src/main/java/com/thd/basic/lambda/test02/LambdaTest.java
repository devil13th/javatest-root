package com.thd.basic.lambda.test02;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaTest extends TestCase {
    @Test
    public void test01() {
        //举例1
        Consumer<String> con = (x) -> System.out.println(x);//使用Lambda表达式
        con.accept("Hello");
        Consumer<String> con1 = System.out::println;		//使用方法引用
        con1.accept("World");
        //举例2
        Student student = new Student("Moti",10,"男");
        Supplier<String> stuName = () -> student.getName();	//使用Lambda表达式
        System.out.println(stuName.get());
        Supplier<String> stuName1 = student::getName;		//使用方法引用
        System.out.println(stuName1.get());

        //举例3
        Comparator<Integer> com = (x,y) -> Integer.compare(x, y);//使用Lambda表达式
        Comparator<Integer> com1 = Integer::compare;			 //使用方法引用

        // 举例4
        BiPredicate<String, String> bp = (x,y) -> x.equals(y);	 //使用Lambda表达式
        BiPredicate<String, String> bp1 = String::equals;		 //使用方法引用
    }



    @Test
    public void test02x(){
        Thread thread = new Thread(() -> {System.out.println("lambda");});
        thread.start();

        System.out.println("finish");
    }
}
