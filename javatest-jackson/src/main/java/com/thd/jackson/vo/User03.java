package com.thd.jackson.vo;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thd.jackson.tools.ItemDeserializer;
import com.thd.jackson.tools.ItemSerializer;

import java.io.Serializable;

public class User03 implements Serializable {
    private String userId;
    private String userName;

    @JsonDeserialize(using = ItemDeserializer.class)
    @JsonSerialize(using = ItemSerializer.class)
    private Item item;

    @Override
    public String toString() {
        return "User03{" +
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
