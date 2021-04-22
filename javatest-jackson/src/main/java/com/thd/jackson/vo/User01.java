package com.thd.jackson.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User01 implements Serializable {

    //不JSON序列化的属性
    @JsonIgnore
    private String userId;
    private String userName;
    private Integer userAge;

    //格式化日期属性
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date userBirthday;

    //序列化userCreateTime属性为createTime
    @JsonProperty("createTime")
    private Timestamp userCreateTime;

    //用来忽略NULL属性，空的属性或者NULL的类
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String testNull;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Timestamp getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Timestamp userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public String getTestNull() {
        return testNull;
    }

    public void setTestNull(String testNull) {
        this.testNull = testNull;
    }

    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String birthdayStr = "";
        if(this.getUserBirthday() != null){
            birthdayStr = sdf.format(this.getUserBirthday());
        }

        String createTimeStr = "";
        if(this.getUserCreateTime() != null ){
            createTimeStr = sdf.format(new Date(this.getUserCreateTime().getTime()));
        }

        return "MyUser{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userBirthday=" + birthdayStr +
                ", userCreateTime=" + createTimeStr +
                '}';
    }
}
