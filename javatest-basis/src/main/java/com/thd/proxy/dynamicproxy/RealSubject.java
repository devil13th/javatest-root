package com.thd.proxy.dynamicproxy;

public class RealSubject implements Subject {

	@Override
    public void rent()
    {
        System.out.println("被代理:I want to rent my house");
    }
    
    @Override
    public void hello(String str)
    {
        System.out.println("被代理:hello: " + str);
    }

}
