package com.thd.basic.stream;

public class MyBean {
    private int groupA;
    private int groupB;

    @Override
    public String toString() {
        return "MyBean{" +
                "groupA=" + groupA +
                ", groupB=" + groupB +
                '}';
    }

    public MyBean(int groupA, int groupB) {
        this.groupA = groupA;
        this.groupB = groupB;
    }

    public int getGroupA() {
        return groupA;
    }

    public void setGroupA(int groupA) {
        this.groupA = groupA;
    }

    public int getGroupB() {
        return groupB;
    }

    public void setGroupB(int groupB) {
        this.groupB = groupB;
    }
}
