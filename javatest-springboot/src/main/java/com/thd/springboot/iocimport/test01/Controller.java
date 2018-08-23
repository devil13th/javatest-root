package com.thd.springboot.iocimport.test01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class Controller {
	@Autowired
	private BeanB beanB;
	@Autowired
	private BeanA beanA;
	@Autowired
	private BeanC beanC;
	@Autowired
	private BeanD beanD;
	@Autowired
	private BeanE beanE;
	@Autowired
	private BeanF beanF;
	@Autowired
	private BeanG beanG;
	@Autowired
	private SpringUtil springUtil;
	@RequestMapping(value="/index")
	public String index(){
		
		System.out.println("---------------------");
		System.out.println(beanA);
		System.out.println(beanB);
		System.out.println(beanC);
		System.out.println(beanC.getBeanD());
		System.out.println(beanD);
		System.out.println(beanE);
		System.out.println(beanE.getBeanF());
		System.out.println(beanF);
		System.out.println(beanG);
		System.out.println(beanG.getStr());
		System.out.println(beanG.getName());
		System.out.println(beanG.getAge());
		System.out.println(beanG.getBookName());
		
		System.out.println(springUtil.getBean("beanG"));
		return "a";
	}
}
