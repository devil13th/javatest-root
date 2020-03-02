package com.thd.basic.optional;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Optional;
import java.util.Random;

/**
 * com.thd.basic.optional.OptionalTest
 *
 * @author: wanglei62
 * @DATE: 2020/2/28 8:31
 **/

public class OptionalTest extends TestCase {

    @Test
    public void test01(){
        Optional<Student> emptyOpt = Optional.empty();
        Student st = emptyOpt.get();
        System.out.println(st); // java.util.NoSuchElementException: No value present
    }

    @Test
    public void test02(){
        Student st = new Student("zhangsan",5,"1");
        Optional<Student> emptyOpt = Optional.of(st);
        Student student = emptyOpt.get();
        System.out.println(student); // java.util.NoSuchElementException: No value present


        Optional<Student> student1 = Optional.ofNullable(null);
        System.out.println(student1); // Optional.empty

        Optional<Student> student2 = Optional.of(null); // java.lang.NullPointerException
    }


    @Test
    public void test03(){
        Student st = new Student("zhangsan",5,"1");
        Optional<Student> opt = Optional.of(st);
        opt.ifPresent(System.out::println);

        Optional<Student> opt2 = Optional.of(null);
        opt.orElseGet( () -> st);
    }



    @Test
    public void test04(){
        Student st = null;
        int ran = new Random().nextInt(50) ;
        System.out.println(ran);
        if( ran % 2 == 0){
            System.out.println("st 不为空 ");
            st = new Student("zhangsan",5,"1");
        }else{
            System.out.println("st 是 空");
        }

        // 到底st 是否为null 谁也不知道

        Optional<Student> opt = Optional.ofNullable(st);

        // 使用orElseGet进行判断是否为空，而不是 isPresent()！！！！！！
        // 如果空则Optionl中的值为 new Student("lisi" .... );
        String studentName = opt.orElseGet(() ->new Student("lisi",3,"0")).getName();
        System.out.println(studentName);
    }
}
