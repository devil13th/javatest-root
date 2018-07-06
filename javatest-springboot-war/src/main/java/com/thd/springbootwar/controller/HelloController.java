package com.thd.springbootwar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/Hello")
public class HelloController {
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public ModelAndView hello(String name){
		System.out.println(name);
		Map m = new HashMap();
		m.put("name", name);
		return new ModelAndView("index",m);
	}
}
