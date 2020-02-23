package com.thd.basic.lambda.test;
// @FunctionalInterface 注释代表该接口只有一个抽象公共方法
@FunctionalInterface
public interface MyFilter {
    public boolean test(Person person);

}
