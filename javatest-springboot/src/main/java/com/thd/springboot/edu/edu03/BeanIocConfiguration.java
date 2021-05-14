package com.thd.springboot.edu.edu03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * com.thd.springboot.edu.edu03.BeanIocConfiguration
 *
 * @author: wanglei62
 * @DATE: 2021/4/25 11:47
 **/
@Configuration
public class BeanIocConfiguration {
    @Bean
    public MyBean01 myBean01(MyBean02 myBean02){
        MyBean01 mb = new MyBean01();
        mb.setMyBean02(myBean02);
        return mb;
    }

}
