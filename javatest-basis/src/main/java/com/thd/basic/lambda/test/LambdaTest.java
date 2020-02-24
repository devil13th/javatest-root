package com.thd.basic.lambda.test;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;


public class LambdaTest extends TestCase {

    /**
     * 查出列表中岁数大于30 的人
     * 查出列表中女生的人
     *
     * 原始写法
     * 缺点：代码量大
     */
    @Test
    public void test01(){
        List<Person> list = Data.getData();
        List<Person> resultList = new ArrayList<>();
        for(Person p : list){
            if(p.getAge() > 10){
                resultList.add(p);
            }
        }
        System.out.println("=========== 年龄大于10的人 ============");
        for(Person p : resultList){
            System.out.println(p);
        }

        System.out.println("=========== 性别是男的人 ============");
        resultList.clear();

        for(Person p : list){
            if("1".equals(p.getSex())){
                resultList.add(p);
            }
        }

        for(Person p : resultList){
            System.out.println(p);
        }


    }

    /**
     * 查出列表中岁数大于30 的人
     * 查出列表中女生的人
     *
     * 使用策略模式
     * 缺点：策略类大爆炸
     *       代码量大
     */
    @Test
    public void test02(){
        List<Person> list = Data.getData();
        List<Person> resultList = new ArrayList<>();
        System.out.println("=========== 年龄大于10的人 ============");
        MyFilter ageFilter = new MyFilterThatAgeMoreThan();
        for(Person p : list){
            if(ageFilter.test(p)){
                resultList.add(p);
            }
        }
        for(Person p : resultList){
            System.out.println(p);
        }
        resultList.clear();
        System.out.println("=========== 性别是男的人 ============");
        MyFilter sexFilter = new MyFilterThatSex();

        for(Person p : list){
            if(sexFilter.test(p)){
                resultList.add(p);
            }
        }
        for(Person p : resultList){
            System.out.println(p);
        }
    }


    /**
     * 查出列表中岁数大于30 的人
     * 查出列表中女生的人
     *
     * 使用lambda表达式
     */
    @Test
    public void test03(){
        List<Person> list = Data.getData();
        List<Person> resultList = new ArrayList<>();
        System.out.println("=========== 年龄大于10的人 ============");
        list.forEach(p -> {
            if(p.getAge() > 10){
                System.out.println(p);
            }
        });
        System.out.println("=========== 性别是男的人 ============");
        list.forEach(p -> {
            if("1".equals(p.getSex())){
                System.out.println(p);
            }
        });
    }

    /**
     * 查出列表中岁数大于30 的人
     * 查出列表中女生的人
     *
     * 使用lambda表达式
     */
    @Test
    public void test03a(){
        List<Person> list = Data.getData();
        list.forEach(System.out::println);

    }


    @Test
    public void test04(){
        Runnable r = () -> {System.out.println(Thread.currentThread().getName());};
        Thread t = new Thread(r);
        t.start();
    }
    @Test
    public void test05(){
        Runnable r = () -> {System.out.println(Thread.currentThread().getName());};
        for(int i = 0 , j = 10 ; i < j ; i++){
            Thread t = new Thread(r);
            t.start();
        }
    }

    /**
     * 方法引用
     */
    @Test
    public void test06(){
        MyFilter f = (x) -> x.getAge() > 5;

        MyFilter f1 = new MyFilterThatAgeMoreThan();

        MyFilter f2 = f1::test;

        List<Person> list = Data.getData();
        List<Person> resultList = new ArrayList<>();
        System.out.println("=========== 年龄大于5的人 ============");
        list.forEach(p -> {
            if(f.test(p)){
                System.out.println(p);
            }
        });

    }

    /**
     * 方法引用 - 静态方法
     */
    @Test
    public void test07(){

        BiPredicate<String, String> bp = (x,y) -> x.equals(y);	 //使用Lambda表达式
        BiPredicate<String, String> bp1 = String::equals;		 //使用方法引用

        List<Person> p = Data.getData();
        p.forEach(StaticMyFilter::test);
    }


}
