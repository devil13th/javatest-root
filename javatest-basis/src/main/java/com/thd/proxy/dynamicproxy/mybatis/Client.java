package com.thd.proxy.dynamicproxy.mybatis;

import java.util.List;

/**
 * com.thd.proxy.dynamicproxy.mybatis.Client
 *
 * @author: wanglei62
 * @DATE: 2020/11/4 9:09
 **/
public class Client {
    public static void main(String[] args){
        UserMapper u = (UserMapper)(new UserMapperProxy(UserMapper.class).getProxy());
        List s = u.queryByName("ss");
        System.out.println("返回结果：");
        s.stream().forEach(System.out::print);
    }
}
