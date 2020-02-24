package com.thd.basic.lambda.methodreference;

import java.time.LocalDate;

/**
 * com.thd.basic.lambda.methodreference.Person
 *
 * @author: wanglei62
 * @DATE: 2020/2/24 12:34
 **/
public class Person {
    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    String name;
    LocalDate birthday;

    public LocalDate getBirthday() {
        return birthday;
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void printSelf(Person p){
        System.out.println(this.getName() + " | " + p.getName());
    }

    public void printSelf(){
        System.out.println(this.getName() );
    }
}
