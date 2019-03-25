package com.thd.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		
		//我们要代理的真实对象
		Subject realSubject = new RealSubject();
		//我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
		InvocationHandler handler = new DynamicProxy(realSubject);
		
		/*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         * 
         * 通过这个动态代理对象 来的调用我们自己的代理对象 来执行方法
         */
		Subject subject = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(),handler);
		
		System.out.println(subject.getClass().getName());
		
		subject.rent();
		subject.hello(" dynamic proxy ");
		
		
		/*
		 * 代理对象是在程序运行时产生的，而不是编译期；
		 * 对代理对象的所有接口方法调用都会转发到InvocationHandler.invoke()方法，
		 * 在invoke()方法里我们可以加入任何逻辑，
		 * 比如修改方法参数，加入日志功能、安全检查功能等；之后我们通过某种方式执行真正的方法体，
		 * 示例中通过反射调用了Hello对象的相应方法，还可以通过RPC调用远程方法。
		 * 
		 * 限制:Java动态代理是基于接口的


		 */
	}

}
