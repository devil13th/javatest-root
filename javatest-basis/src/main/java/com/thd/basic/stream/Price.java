package com.thd.basic.stream;

import java.math.BigDecimal;

/**
 * com.thd.basic.stream.Price
 *
 * @author: wanglei62
 * @DATE: 2020/3/27 9:33
 **/
public class Price {
    private String name;
    private Integer num;
    private BigDecimal price;

    public Price(String name, Integer num, BigDecimal price) {
        this.name = name;
        this.num = num;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Price{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", price=" + price +
                '}';
    }
}
