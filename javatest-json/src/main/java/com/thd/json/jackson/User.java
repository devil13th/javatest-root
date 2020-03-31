package com.thd.json.jackson;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class User {
    private String name;
    private Date birthday;
    private LocalDateTime createTime;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(this.birthday);
        return "User{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", createTime=" + dateStr +
                '}';
    }
}
