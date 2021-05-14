package com.thd.springboot.edu.edu03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * com.thd.springboot.edu.edu03.Controller
 *
 * @author: wanglei62
 * @DATE: 2021/4/25 11:49
 **/
@Controller
public class MyController  {
    @Autowired
    private MyBean01 myBean01;

    @RequestMapping("/test")
    @ResponseBody
    // url : http://127.0.0.1:8888/sbt/test
    public ResponseEntity test(){
        return ResponseEntity.ok(myBean01);
    }

}
