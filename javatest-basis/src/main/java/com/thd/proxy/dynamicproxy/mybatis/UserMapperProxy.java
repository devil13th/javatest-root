package com.thd.proxy.dynamicproxy.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * com.thd.proxy.dynamicproxy.mybatis.UserMapperProxy
 *
 * @author: wanglei62
 * @DATE: 2020/11/4 9:07
 **/
public class UserMapperProxy implements InvocationHandler {
    // 被代理的接口
    private Class c ;
    public UserMapperProxy(Class c){
        this.c = c;
    };
    // 创建代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(c.getClassLoader(),new Class[]{c},this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("====== 代理开始");
        System.out.println("  代理方法名称" + method.getName());
        System.out.println("  这里执行自定义的代码");
        System.out.println("  入口参数：");
        if(args!=null && args.length > 0){
            Arrays.stream(args).forEach(System.out::println);
        }
        List<String> l = new ArrayList();
        l.add("zhangsan");
        l.add("lisi");
        l.add("wangwu");
        System.out.println("====== 代理结束");
        return l;
    }
}
