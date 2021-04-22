package com.thd.jackson.vo;


import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User02 implements Serializable {
    private String userId;
    private String userName;
    private Item item;

    @Override
    public String toString() {
        return "User02{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", item=" + item +
                '}';
    }

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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
