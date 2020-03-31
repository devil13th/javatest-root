package com.thd.json.fastjson;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Timestamp;
import java.util.Date;

/**
 * com.thd.json.Person
 *
 * @author: wanglei62
 * @DATE: 2019/12/18 22:57
 **/
public class Person {
    @JSONField(ordinal = 1)
    private String name;
    // 不进行序列化
    @JSONField(serialize=false)
    private String nickName;

    //指定顺序 指定json属性名
    @JSONField(ordinal = 4,name="myAge")
    private Integer age;

    // 指定日期格式 (序列化和反序列化)
    @JSONField(format="yyyyMMdd",ordinal = 2)
    private Date birthday;

    @JSONField(ordinal = 3)
    private Timestamp createTime;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", createTime=" + createTime +
                '}';
    }
}
