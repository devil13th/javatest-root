package com.thd.spring.loadcfg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class LoadCfg {
	/**
	 * Spring 以classpath形式加载配置文件例子
	 */
	public void ClassPathLoad(int i) {

		if (i == 1) {
			/*
			 * 以"classpath:"开头则是从src(项目生成的class根目录)目录下逐级文件夹找 、
			 * 下面例子是在src/com/thd/spring/loadcfg文件夹下找
			 * 如果是根目录则是classpath:applicationContext-classpathload-A.xml
			 */

			ApplicationContext factory = new ClassPathXmlApplicationContext(
					"classpath:com/thd/spring/loadcfg/applicationContext-classpathload-A.xml");
			TestBeanA bean = (TestBeanA) factory.getBean("testBeanA");
			bean.test();
			
			
		} else if (i == 2) {
			/*
			 * 上例中的"classpath:"也可以省去
			 */
			ApplicationContext factory = new ClassPathXmlApplicationContext(
					"com/thd/spring/loadcfg/applicationContext-classpathload-A.xml");
			TestBeanA bean = (TestBeanA) factory.getBean("testBeanA");
			bean.test();
			
			
		}else if(i == 3){
			/*
			 * 加载多个配置文件
			 */
			String[] str = new String[]{"com/thd/spring/loadcfg/applicationContext-classpathload-A.xml","com/thd/spring/loadcfg/applicationContext-classpathload-B.xml"};
			ApplicationContext factory = new ClassPathXmlApplicationContext(str);
			TestBeanA beanA = (TestBeanA) factory.getBean("testBeanA");
			beanA.test();
			TestBeanB beanB = (TestBeanB) factory.getBean("testBeanB");
			beanB.test();
			
			
		}else if(i == 4){
			/*
			 * spring 配置文件中引入另外一个配置文件
			 * <import resource="applicationContext-classpathload-A.xml"/>
			 * <import resource="applicationContext-classpathload-B.xml"/>
			 */
			ApplicationContext factory = new ClassPathXmlApplicationContext("com/thd/spring/loadcfg/applicationContext-classpathload-C.xml");
			TestBeanA beanA = (TestBeanA) factory.getBean("testBeanA");
			beanA.test();
			TestBeanB beanB = (TestBeanB) factory.getBean("testBeanB");
			beanB.test();
		}

	}

}
