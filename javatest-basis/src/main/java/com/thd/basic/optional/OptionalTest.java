package com.thd.basic.optional;

import jdk.nashorn.internal.runtime.options.Option;
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
    /**
     * of 方法进行设置值
     * 但不能赋空值
     */
    @Test
    public void testOf(){
        Optional<Student> emptyOpt = Optional.empty();
        Student st = emptyOpt.get();
        System.out.println(st); // java.util.NoSuchElementException: No value present
    }
    /**
     * ofNullable 方法进行设置值
     * 能赋空值
     */
    @Test
    public void testOfNullable(){
        /**
         * 明确对象不为 null  的时候使用 of()
         * 如果对象即可能是 null 也可能是非 null，你就应该使用 ofNullable() 方法
         */
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

    /**
     * orElse方法
     */
    @Test
    public void testOrElse(){
        // 对象不为空则返回该对象
        Student st = new Student("zhangsan",5,"1");
        Optional<Student> opt = Optional.of(st);
        Student r = opt.orElse(new Student("lisi",5,"0"));
        System.out.println("=====" + r);

        // 对象是空则返回orElse中的值
        Optional<Student> nullOpt = Optional.ofNullable(null);
        Student r2 = nullOpt.orElse(new Student("wangwu",5,"0"));
        System.out.println("=====" + r2);
    }


    /**
     * orElseGet方法
     */
    @Test
    public void testOrElseGet(){
        Student st = new Student("zhangsan",5,"1");
        Optional<Student> opt = Optional.of(st);
        Student r = opt.orElseGet(()->new Student("lisi",5,"0"));
        System.out.println("=====" + r);

        Optional<Student> nullOpt = Optional.ofNullable(null);
        Student r2 = nullOpt.orElseGet(()->new Student("wangwu",5,"0"));
        System.out.println("=====" + r2);
    }


    /**
     * orElse 和  orElseGet区别
     */
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

        //orElse   使用的第一个方法是 orElse()，它的工作方式非常直接，如果有值则返回该值，否则返回传递给它的参数值
        System.out.println("---Using orElse");
        System.out.println(opt.orElse(new Student("h",3,"0")));

        System.out.println("---Using orElseGet");
        // 使用orElseGet进行判断是否为空，而不是 isPresent()！！！！！！
        // 如果空则Optionl中的值为 new Student("lisi" .... );
        String studentName = opt.orElseGet(() ->new Student("lisi",3,"0")).getName();
        System.out.println(studentName);



        /**
         * 结论：当Optional的值是空时  orElse 和 orElseGet无差别
         * 当Optional的值不空的时候 orElse仍会运行方法体内的代码,orElseGet则不会运行,直接返回Optional的值
         */
    }


    /**
     * map方法，返回一个对象的处理结果
     */
    public void testMap(){
        Student st = new Student("zhangsan",5,"1");
        String name = Optional.of(st).map( v -> v.getName()).orElseGet(() -> "");
        System.out.println(name);
    }

    /**
     * flatMap方法，返回一个对象的处理结果
     * 该方法与map方法类似，只不过要返回一个Optional对象
     */
    public void testFlatMap(){
        Student st = new Student("zhangsan",5,"1");
        String name = Optional.of(st).flatMap( v -> Optional.of(v.getName())).orElseGet(() -> "");
        System.out.println(name);
    }

    /**
     * filter方法
     * 如果满足filter中的条件则返回当前Optional的对象否则返回空对象
     */
    public void testFilter(){
        Student st = new Student("zhangsan",5,"1");
        Student r = Optional.of(st).filter( opt -> opt.getAge() > 10).orElseGet(Student::new);
        System.out.println(r);
    }

    /**
     * isPresent方法
     * 判断Optional中是否有值  -  不应该使用该方法，应使用orElse 或  orElseGet方法来返回一个新的值
     * ifPresent 方法
     * 如果不为空则执ifPresent中的方法行否则不执行
     */
    public void testIfPresent(){
        Student st = null;
        System.out.println(Optional.ofNullable(st).isPresent()); // false
        Optional.ofNullable(st).filter( u -> u.getAge() > 18).ifPresent(u ->  System.out.println("The student age is more than 18.")); // 不输出因为Optional的值是空

        System.out.println("--------------------");

        st = new Student("zhangsa",20,"0");
        System.out.println(Optional.ofNullable(st).isPresent()); // false
        Optional.ofNullable(st).filter( u -> u.getAge() > 18).ifPresent(u ->  System.out.println("The student age is more than 18.")); // 不输出因为Optional的值是空

    }

    @Test
    // 去除if
    public void testRemoveIf(){
        Student st = new Student();
        Address addr = new Address("北京西城");
        st.setAddr(addr);


        // 传统写法
        if(st != null){
            Address ad = st.getAddr();
            if(ad != null){
                String adStr = ad.getAddr();
                if(null != adStr){
                    System.out.println(" do something");
                }
            }
        }


        // 去除if, 无论是student还是addr或是addr.addr属性 为空就会抛出异常,避免了一层层的检查
        // 测试1  student是null
        Optional<Student> stOpt = Optional.ofNullable(null);
        try{
            String addrStr = stOpt.map(item -> item.getAddr()).map(item -> item.getAddr()).orElseThrow( () -> new RuntimeException("没有地址"));
            System.out.println(addrStr);
        }catch(Exception e){
            System.out.println("测试1" + e.getMessage());
        }


        // 测试2 address是null
        try{
            Student st2 = new Student();
            String addrStr2 = Optional.ofNullable(st2).map(item -> item.getAddr()).map(item -> item.getAddr()).orElseThrow( () -> new RuntimeException("没有地址"));
            System.out.println(addrStr2);
        }catch(Exception e){
            System.out.println("测试2" + e.getMessage());
        }


        // 测试3 address.addr属性是空
        Student st3 = new Student();
        Address ad3 = new Address(null);
        try{
            String addrStr3 = Optional.ofNullable(st3).map(item -> item.getAddr()).map(item -> item.getAddr()).orElseThrow( () -> new RuntimeException("没有地址"));
            System.out.println(addrStr3);
        }catch(Exception e){
            System.out.println("测试3" + e.getMessage());
        }





    }

}
