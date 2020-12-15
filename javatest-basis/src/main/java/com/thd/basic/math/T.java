package com.thd.basic.math;

import java.math.BigDecimal;

/**
 * com.thd.basic.math.T
 *
 * @author: wanglei62
 * @DATE: 2020/9/9 11:12
 **/
public class T {
    public static void main(String[] args){
        BigDecimal x = BigDecimal.valueOf(4/5*100);
        System.out.println(x);

        BigDecimal z = new BigDecimal(4).divide(new BigDecimal(5)).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(z);

        String a = "1234";
        System.out.println(a.substring(0,2));
    }
}
