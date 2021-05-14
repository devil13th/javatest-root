package com.thd.basic.lambda.test03;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Test03 {
    private String a;
    private String b;

    public String deal(BiFunction<String,String,String> fun){
        return fun.apply(this.a,this.b);
    }
    public Test03(String a , String b){
        this.a = a ;
        this.b = b;
    }


    public static void main(String[] args){
        Test03 t = new Test03("thd","devil13th");
        String r = t.deal( (a,b) -> {
            return a + b;
        });
        System.out.println(r);
    }
}
