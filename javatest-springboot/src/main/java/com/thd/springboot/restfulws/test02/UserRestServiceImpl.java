package com.thd.springboot.restfulws.test02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class UserRestServiceImpl implements UserRestService {

	static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
	
	
	
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    public String postUser(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "success";
    }

    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
    
    /**
     * url : http://127.0.0.1:8888/sbt/users/createUser/2?name=name1&age=5
     *       http://127.0.0.1:8888/sbt/users/createUser/6?name=name1&age=5
     */
    public String createUser(@PathVariable Long id, @ModelAttribute User user){
    	System.out.println("---------------");
    	System.out.println(id);
    	System.out.println(user.getName());
    	System.out.println(user.getAge());
    	System.out.println("---------------");
		User u = new User();
		u.setId(id);
		u.setName(user.getName());
		u.setAge(user.getAge());
		users.put(id, u);
		return "success";
    };

}
