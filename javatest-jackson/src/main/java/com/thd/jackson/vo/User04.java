package com.thd.jackson.vo;



import java.io.Serializable;
import java.util.List;

public class User04 implements Serializable {
    private String userId;
    private String userName;
    private List<Item> itemList;

    @Override
    public String toString() {
        return "User03{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", item=" + itemList +
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

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
