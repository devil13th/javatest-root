package com.thd.basic.lambda.test;

public class MyFilterThatSex implements MyFilter {
    public boolean test(Person p){
        return "1".equals(p.getSex());
    };
}
