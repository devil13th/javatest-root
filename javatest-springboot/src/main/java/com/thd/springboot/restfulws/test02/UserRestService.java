package com.thd.springboot.restfulws.test02;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/users")
public interface UserRestService {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//get url http://127.0.0.1:8888/sbt/users/
    List<User> getUserList();
	
    @RequestMapping(value = "/", method = RequestMethod.POST)
    //post url http://127.0.0.1:8888/sbt/users/
    String postUser(@ModelAttribute User user);
    //get url http://127.0.0.1:8888/sbt/users/5
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable Long id);

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    String putUser(@PathVariable Long id, @ModelAttribute User user);

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    String deleteUser(@PathVariable Long id);
    
    
    @RequestMapping(value="/createUser/{id}", method=RequestMethod.GET)
    //get url http://127.0.0.1:8888/sbt/users/createUser/6?name=name1&age=5
    String createUser(@PathVariable Long id, @ModelAttribute User user);
}
