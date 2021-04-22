package com.thd.jackson.vo;


import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
public class User implements Serializable {
    private String userId;
    private String userName;
    private Integer userAge;

    private Date userBirthday;

    private Timestamp userCreateTime;

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
