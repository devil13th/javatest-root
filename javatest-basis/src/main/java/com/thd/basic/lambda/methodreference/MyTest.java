package com.thd.basic.lambda.methodreference;

import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * com.thd.basic.lambda.methodreference.Test
 *
 * @author: wanglei62
 * @DATE: 2020/2/24 12:36
 **/
public class MyTest extends TestCase {
    @Test
    public void test01(){
       Person[] pArr = new Person[]{
               new Person("zhangsan", LocalDate.of(2019,12,1)),
               new Person("lisi", LocalDate.of(2019,12,2)),
               new Person("wangwu", LocalDate.of(2019,12,4)),
               new Person("zhaoliu", LocalDate.of(2019,12,3))
       };
        Arrays.asList(pArr).sort(Person::compareByAge);
        System.out.println(Arrays.asList(pArr));
   }

    @Test
    public void test02(){
        Person[] pArr = new Person[]{
                new Person("zhangsan", LocalDate.of(2019,12,1)),
                new Person("lisi", LocalDate.of(2019,12,2)),
                new Person("wangwu", LocalDate.of(2019,12,4)),
                new Person("zhaoliu", LocalDate.of(2019,12,3))
        };

        Arrays.asList(pArr).forEach(Person::getBirthday);
        Arrays.asList(pArr).forEach(pArr[0]::printSelf);
        Arrays.asList(pArr).forEach( p -> {System.out.println(p);});
        Arrays.asList(pArr).forEach( System.out::println);
        System.out.println(Arrays.asList(pArr));
    }
}
