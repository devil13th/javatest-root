package com.thd.springboot.edu.jdbctemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller {
	

	
	@Resource
	private HelloDao helloDao;
	
	@RequestMapping("/jdbctemplate/query")
	//url http://127.0.0.1:8888/sbt/jdbctemplate/query
	public List query(@RequestParam(value="name", defaultValue="World") String name) {
		System.out.println("----------------------");
		return helloDao.queryForList();
	}
}
