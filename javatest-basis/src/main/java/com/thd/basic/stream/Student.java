package com.thd.basic.stream;

public class Student {
    private String name;
    private Integer age;
    private Integer type;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Student(String name, Integer age, Integer type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }
}
