package com.thd.basic.lambda.test;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Person> data = new ArrayList<>();
    public static List<Person> getData(){

        if(data.size() == 0){
            int i  = 0;
            while(i<20){
                String name = "person_" + i;
                String sex = i % 2 == 0 ? "1" : "0";
                int age = i;
                Person p = new Person(age,name,sex);
                data.add(p);
                i++;
            }
        }
        return data;
    }
}
