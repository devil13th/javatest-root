package com.thd.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 自定义MethodInterceptor
 */
public class MyMethodInterceptor implements MethodInterceptor {

	/**
     * sub：cglib生成的代理对象  表示增强的对象，即实现这个接口类的一个对象
     * method：被代理对象方法 表示要被拦截的方法
     * objects：方法入参  表示要被拦截方法的参数
     * methodProxy: 代理方法   表示要触发父类的方法对象
     */
    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("======插入前置通知======");
        System.out.println(method.getName());
        System.out.println(methodProxy.getSuperName());
        Object object = methodProxy.invokeSuper(sub, objects);
        System.out.println("======插入后者通知======");
        return object;
    }

}
