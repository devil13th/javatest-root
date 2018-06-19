package com.thd.proxy.advance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean implements InvocationHandler {
	private Object target;
    public Object getProxy(Object target){
        this.target = target;  
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);  
    }
	public Object invoke(Object obj, Method method, Object[] args)
			throws Throwable {
	        Object ret = null;//返回值
	        try{
	            System.out.println("安全性检查开始");
	            ret = method.invoke(this.target, args);
	            System.out.println("日志");
	        }catch(Exception e){  
	            e.printStackTrace();
	        }  
	        return ret;
	}
}

/*
 * 说明：
 * 有诸多接口AService BService....
 * 每个接口有自己的实现类AServiceImpl,BServiceImpl
 * 在这些接口的所有方法执行之前加入安全性检查，在方法执行之后加入记录日志的功能
 * 
 * 如果要用静态代理，势必每个实现类都要生成一个代理类，代理类实现被代理类的接口
      同时要执行实现类中的方法，如果实现类过多的时候会产生类爆炸现象，而且接口中的每个方法都要在代理类中写一遍实现
 * 
 * 所以要减少类爆炸，又想用接口直接定义实现类对象
 * 例如：UserManager u = (UserManager)....的形式，通过u.method()的方式来调用
 * 就要用到Proxy.newProxyInstance来生成代理类
 * 
 * newProxyInstance方法需要一个InvocationHandler类型的参数
 * 
 * 所以动态代理需要用到 Proxy 和 InvocationHandler 两个类来实现
 * 
 * InvocationHandler是一个接口，其实现类要实现invoke(Object obj, Method method, Object[] args)方法 
 *     obj:被代理的对象
 *     method:调用的方法
 *     args:方法的参数
 * 
 * 如果仅仅实现InvocationHandler接口那么其invoke方法中的obj势必要写死，比如实现UserManager的某个方法就要实例化UserManager的实现类
 * 所以要自定义一个类(例子中的ProxyBean)，实现InvocationHandler，定义了一个Object target,这个target是被代理的实现类(例子中的UserManagerImpl),这个类的getProxy方法中设置被代理的对象target
 * 
 * ProxyBean.getProxy()会返回一个代理，这个代理对象强制转换成你的接口(例子中的UserManager)类型，之后就可以直接用 object.method()方法了
 * 
 */
