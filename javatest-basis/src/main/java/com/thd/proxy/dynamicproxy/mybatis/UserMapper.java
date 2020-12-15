package com.thd.proxy.dynamicproxy.mybatis;

import java.util.List;

/**
 * com.thd.proxy.dynamicproxy.mybatis.UserMapper
 *
 * @author: wanglei62
 * @DATE: 2020/11/4 9:06
 **/
public interface UserMapper {
    public List<String> queryByName(String name);
}
