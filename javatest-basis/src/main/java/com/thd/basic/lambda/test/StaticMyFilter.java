package com.thd.basic.lambda.test;

public class StaticMyFilter {
    public static boolean test(Person p){
        System.out.println(p);
        return p.getAge() > 5;
    }
}
