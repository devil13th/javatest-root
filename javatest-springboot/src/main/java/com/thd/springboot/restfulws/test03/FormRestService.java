package com.thd.springboot.restfulws.test03;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thd.springboot.restfulws.test02.User;

@RequestMapping(value = "/form/")
public interface FormRestService {
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//get url http://127.0.0.1:8888/sbt/form/
	public List<Form> getFormList();
	
}
