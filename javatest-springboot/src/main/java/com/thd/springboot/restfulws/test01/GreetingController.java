package com.thd.springboot.restfulws.test01;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/springboot/greeting")
	//url http://127.0.0.1:8080/springboot/greeting?name=devil13th
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
	    return new Greeting(counter.incrementAndGet(),String.format(template, name));
	}
}
