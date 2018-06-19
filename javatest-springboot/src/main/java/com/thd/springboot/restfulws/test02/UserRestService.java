package com.thd.springboot.restfulws.test02;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/users")
public interface UserRestService {
	@RequestMapping(value = "/", method = RequestMethod.GET)
    List<User> getUserList();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    String postUser(@ModelAttribute User user);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable Long id);

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    String putUser(@PathVariable Long id, @ModelAttribute User user);

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    String deleteUser(@PathVariable Long id);
    
    
    @RequestMapping(value="/createUser/{id}", method=RequestMethod.GET)
    String createUser(@PathVariable Long id, @ModelAttribute User user);
}
