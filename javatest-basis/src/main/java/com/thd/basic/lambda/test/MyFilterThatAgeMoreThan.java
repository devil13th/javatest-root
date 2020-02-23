package com.thd.basic.lambda.test;

public class MyFilterThatAgeMoreThan implements MyFilter{
    public boolean test(Person p){
        return p.getAge() > 10;
    };
}
