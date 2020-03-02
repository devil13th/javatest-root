package com.thd.basic.stream;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 extends TestCase {

    /**
     * 创建流
     * 方法一,集合类的stream方法
     */
    @Test
    public void testCreateStream01(){
        List list = Arrays.asList(new String[]{"zhangsan","lisi","wangwu","zhaoliu"});
        // 使用Collection实例的stream()方法创建流
        Stream st = list.stream();
        st.forEach(System.out::println);
    }

    /**
     * 创建流
     * 方法二,使用Arrays.stream()静态方法
     */
    @Test
    public void testCreateStream02(){
        String[] strArray = new String[]{"zhangsan","lisi","wangwu","zhaoliu"};
        // 使用Arrays.stream()静态方法创建流
        Stream st = Arrays.stream(strArray);
        st.forEach(System.out::println);
    }

    /**
     * 创建流
     * 方法三,使用Stream.of静态方法
     */
    @Test
    public void testCreateStream03(){
        // 使用Stream.of静态方法 创建流
        Stream st = Stream.of(1,2,3,4,5,6);
        st.forEach(System.out::println);
    }

    /**
     * 创建流
     * 方法四,使用Stream.iterat创建一个无限流
     */
    @Test
    public void testCreateStream04(){
        // 使用Stream.iterat创建一个无限流
        Stream st = Stream.iterate(1,(x) -> (int)(Math.random() * 100));
        st.forEach(System.out::println);
    }

    /**
     * 创建流
     * 方法五,使用Stream.generate创建一个无限流
     */
    @Test
    public void testCreateStream05(){
        // 使用Stream.generate创建一个无限流
        Stream st = Stream.generate(() -> Math.random());
        st.forEach(System.out::println);
    }

    /**
     * 流的特点1
     * 不会改变源，最终生成新的流
     */
    @Test
    public void testStreamFeature(){
        List<MyBean> l = new ArrayList<>();
        l.add(new MyBean(1,1));
        l.add(new MyBean(2,2));
        l.add(new MyBean(3,3));
        l.add(new MyBean(4,4));
        l.add(new MyBean(5,5));

        List<MyBean> r = l.stream().filter( item -> item.getGroupA() > 2).collect(Collectors.toList());
        System.out.println("新结果集");
        r.forEach(System.out::println);
        System.out.println("原结果集");
        l.forEach(System.out::println);
    }


    /**
     * 流的特点2
     * 惰性求值，流在中间处理过程中，只是对操作进行了记录，并不会立即执行，需要等到执行终止操作的时候才会进行实际的计算
     */
    @Test
    public void testLayzExecute(){
        List<MyBean> l = new ArrayList<>();
        l.add(new MyBean(1,1));
        l.add(new MyBean(2,2));
        l.add(new MyBean(3,3));
        l.add(new MyBean(4,4));
        l.add(new MyBean(5,5));
        System.out.println(" 并没有执行中间操作,因为没有终止操作");
        l.stream().filter( item -> {
            System.out.println(" -- 中间操作 --" + System.currentTimeMillis());
            System.out.println(item);
            return item.getGroupA() > 2;
        });

        System.out.println(" 执行了中间操作,因为有终止操作，并不是所有中间操作才运行终止操作的");
        l.stream().filter( item -> {
            System.out.println(" -- 中间操作 --" + System.currentTimeMillis());
            System.out.println(item);
            return item.getGroupA() > 2;
        }).forEach(item -> {
            System.out.println(" -- 终止操作 --" + System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(item);
        });


    }



    /**
     * 流的特点3
     * 短路，如果出现limit则不会遍历全部集合
     */
    @Test
    public void testShortCircuit(){
        List<MyBean> l = new ArrayList<>();
        l.add(new MyBean(1,1));
        l.add(new MyBean(2,2));
        l.add(new MyBean(3,3));
        l.add(new MyBean(4,4));
        l.add(new MyBean(5,5));
        System.out.println(" 并没有执行中间操作,因为没有终止操作");
        l.stream().filter(item -> {System.out.println("middle:" + item);return true;}).limit( 2).forEach(item -> System.out.println("final:" + item));

    }




    @Test
    public void testMap(){
        Stream.of("apple","banana","orange","waltermaleon","grape")
                .map(new Function<String,Integer>(){
                    @Override
                    public Integer apply(String s) {
                        return s.length();
                    }
                }) //转成单词的长度 int
                .forEach(e->System.out.println(e)); //输出
    }

    @Test
    public void testMap02(){
        Stream.of("apple","banana","orange","waltermaleon","grape")
                .map(new Function<String,Integer>(){
                    @Override
                    public Integer apply(String s) {
                        return s.length();
                    }
                }) //转成单词的长度 int
                .forEach(e->System.out.println(e)); //输出
    }


    @Test
    public void testMap03(){
        Stream.of("apple","banana","orange","waltermaleon","grape")
                .map(s->s.length()) //转成单词的长度 int
                .forEach(e->System.out.println(e)); //输出
    }

    @Test
    public void testMap04(){
        Stream.of("apple","banana","orange","waltermaleon","grape")
                .map(String::length) //转成单词的长度 int
                .forEach(e->System.out.println(e)); //输出
    }

    @Test
    public void testForeach(){
        String[] array = {"a", "b", "c", "d", "e"};

        //Arrays.stream
        Stream<String> stream1 = Arrays.stream(array);
        stream1.forEach(x -> System.out.println(x));
        //Stream.of
        Stream<String> stream2 = Stream.of(array);
        stream2.forEach(x -> System.out.println(x));
    }



    // --------------------------------  中间操作 -------------------------------------- //

    // 去掉重复元素
    @Test
    public void testDistinct(){
       Stream.of(1,2,3,4,2,3,4,5).distinct().forEach(x -> {System.out.println(x);});
    }

    // 过滤
    @Test
    public void testFilter(){
        Stream.of(1,2,3,4,2,3,4,5).filter((x) -> x > 3).forEach(x -> {System.out.println(x);});
    }


    // 过滤
    @Test
    public void testSort(){
        Stream.of(1,2,3,4,2,3,4,5).sorted( (x,y) -> x <= y ? 1 : -1).forEach(x -> System.out.println(x));

        List<MyBean> mb = new ArrayList<>();
        mb.add(new MyBean(1,1));
        mb.add(new MyBean(2,1));
        mb.add(new MyBean(1,2));
        mb.add(new MyBean(2,2));
        mb.add(new MyBean(2,5));
        mb.add(new MyBean(3,5));
        mb.add(new MyBean(1,4));
        mb.add(new MyBean(2,4));
        mb.add(new MyBean(3,4));
        mb.add(new MyBean(1,5));
        mb.add(new MyBean(3,3));
        mb.add(new MyBean(2,3));
        mb.add(new MyBean(3,2));
        mb.add(new MyBean(1,3));
        mb.stream().sorted( (x,y) -> { return x.getGroupA() > y.getGroupA() ? 1 : x.getGroupA() == y.getGroupA() ? x.getGroupB() > y.getGroupB() ? 1 : -1 : -1 ;})
                .forEach( x -> System.out.println(x));

    }



    // 跳过
    @Test
    public void testSkip(){
        Stream.of(1,2,3,4,5).skip(2).forEach(x -> System.out.println(x));
    }

    // limit
    @Test
    public void testLimit(){
        Stream.of(1,2,3,4,5).limit(3).forEach(x -> System.out.println(x));
    }

    // 模拟分页
    @Test
    public void testSkipAndLimit(){
        Stream.of(1,2,3,4,5,6,7,8,9,10).skip(2).limit(3).forEach(x -> System.out.println(x));
    }


    // --------------------------------  终止操作 -------------------------------------- //

    @Test
    public void testCount(){
        long i = Stream.of(1,2,3,4,5,6,7,8,9,10).count();
        System.out.println(i);
    }

    // 获取第一个
    @Test
    public void testFindFirst(){
        Optional<Integer> opts = Stream.of(1,2,3,4,5,6,7,8,9,10).findFirst();
        System.out.println(opts.get());
    }

    // 获取计算最快的一个 - 并行
    @Test
    public void testFindAny(){
        Optional<Integer> i = Stream.of(1,2,3,4,5,6,7,8,9,10).findAny();
        System.out.println(i.get());
    }

    // 全部满足条件
    @Test
    public void testAllMatch(){
       boolean result =  Stream.of(2,4,6,8,10).allMatch((x) -> x % 2 == 0);
       System.out.println(result);
    }

    // 是否有一个元素条件
    @Test
    public void testAnyMatch(){
        boolean result =  Stream.of(1,2,3,4,5,6,7,8,9,10).anyMatch((x) -> x % 2 == 0);
        System.out.println(result);
    }

    // 是否全部不匹配
    @Test
    public void testNoneMatch(){
        boolean result =  Stream.of(2,4,6,8,10,12,14).noneMatch((x) -> x % 2 == 1);
        System.out.println(result);
    }

    // 取最大
    @Test
    public void testMax(){
        Optional r = Stream.of(2,4,6,8,10,12,14).max((x,y) -> x > y ? 1 : -1);
        System.out.println(r.get());
    }

    // 取最小
    @Test
    public void testMin(){
        Optional r = Stream.of(2,4,6,8,10,12,14).min((x,y) -> x > y ? 1 : -1);
        System.out.println(r.get());
    }

    // 扁平化
    @Test
    public void testFlatMap() {
        Stream.of(1,2,3).flatMap(item -> {
            List<MyBean> l = new ArrayList<MyBean>();
            l.add(new MyBean(item*1,item*2 ));
            l.add(new MyBean(item*3,item*4 ));
            l.add(new MyBean(item*5,item*6 ));
            return l.stream();
        }).forEach(System.out::println);
    }

    // 规约
    @Test
    public void testReduce() {
        Integer r = Stream.of(1, 2, 3, 4).reduce(0, (x, y) -> x + y);
        System.out.println(r);
    }

    // 规约
    @Test
    public void testReduce01(){
        Optional<Integer> r = Optional.of(Stream.of(1,2,3,4).reduce(0,(x,y)-> x+y));
        int i = r.orElse(-1);
        System.out.println(i);
    }

    // 收集
    @Test
    public void testCollect(){
        List<Integer> r = Stream.of(1,2,3,4,5).filter(x-> x > 3).collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    // 收集
    @Test
    public void testCollection(){
        List<String> l  = Stream.of(1,2,3,4,5).map(x -> "name_" + x).collect(Collectors.toList());
        l.forEach(System.out::print);
    }


    // 收集  求个数
    @Test
    public void testCollection01(){
        long s  = Stream.of(1,2,3,4,5).map(x -> "name_" + x).collect(Collectors.counting());
        System.out.println(s);
    }

    // 收集  求平均值
    @Test
    public void testCollection02(){
        double s  = Stream.of(1,2,3,4,5).map(x -> 1 + x).collect(Collectors.averagingInt(x-> new Integer(x)));
        System.out.println(s);
    }

    // 收集 求和
    @Test
    public void testCollection03(){
        int s  = Stream.of(1,2,3,4,5).collect(Collectors.summingInt(Integer :: new));
        System.out.println(s);
    }

    // 收集 求最大值
    @Test
    public void testCollection04(){
        Optional<Integer> r  = Stream.of(1,2,3,4,5).collect(Collectors.maxBy((x,y) -> {
            Integer i = Integer.valueOf(x.toString());
            Integer j = Integer.valueOf(y.toString());
            return Integer.compare(i,j);
        }));
        Integer result = r.orElseGet(() -> {return -1;});
        System.out.println(result);
    }


    // 收集 求最大值
    @Test
    public void testCollection05(){
        Integer r = Stream.of(1,2,3,4,5).collect(Collectors.reducing( 1, (x,y) -> {
           return  x*y;
        }));
        System.out.println(r);
    }



}
