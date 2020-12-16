package com.thd.basic.stream;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorExample {

    public static void main(String[] args){
        Student s1 = new Student("aa", 10,1);
        Student s2 = new Student("bb", 20,2);
        Student s3 = new Student("cc", 10,3);
        Student s4 = new Student("dd", 20,3);
        Student s5 = new Student("ee", 10,3);
        List<Student> list = Arrays.asList(s1, s2, s3, s4, s5);
        System.out.println("========== 转换操作 ===========");
        //转成list
        List<Integer> ageList = list.stream().map(Student::getAge).collect(Collectors.toList()); // [10, 20, 10]
        System.out.println("转成list");
        System.out.println(ageList);
        //转成set
        Set<Integer> ageSet = list.stream().map(Student::getAge).collect(Collectors.toSet()); // [20, 10]
        System.out.println("转成set");
        System.out.println(ageSet);
        //转成map,注:key不能相同，否则报错
        Map<String, Integer> studentMap = list.stream().collect(Collectors.toMap(Student::getName, Student::getAge)); // {cc=10, bb=20, aa=10}
        System.out.println("转成map");
        System.out.println(studentMap);
        //字符串分隔符连接
        String joinName = list.stream().map(Student::getName).collect(Collectors.joining(",", "(", ")")); // (aa,bb,cc)
        System.out.println("字符串分隔符连接");
        System.out.println(joinName);

        System.out.println("========== 聚合操作 ===========");
        //聚合操作
        //1.学生总数
        Long count = list.stream().collect(Collectors.counting()); // 3
        System.out.println("学生总数");
        System.out.println(count);
        //2.最大年龄 (最小的minBy同理)
        Integer maxAge = list.stream().map(Student::getAge).collect(Collectors.maxBy(Integer::compare)).get(); // 20
        System.out.println("最大年龄");
        System.out.println(maxAge);
        //3.所有人的年龄
        Integer sumAge = list.stream().collect(Collectors.summingInt(Student::getAge)); // 40
        System.out.println("所有人的年龄");
        System.out.println(sumAge);
        //4.平均年龄
        Double averageAge = list.stream().collect(Collectors.averagingDouble(Student::getAge)); // 13.333333333333334
        System.out.println("平均年龄");
        System.out.println(averageAge);
        // 带上以上所有方法
        DoubleSummaryStatistics statistics = list.stream().collect(Collectors.summarizingDouble(Student::getAge));
        System.out.println("count:" + statistics.getCount() + ",max:" + statistics.getMax() + ",sum:" + statistics.getSum() + ",average:" + statistics.getAverage());


        System.out.println("========== 分组操作 ===========");
        //分组
        Map<Integer, List<Student>> ageMap = list.stream().collect(Collectors.groupingBy(Student::getAge));
        System.out.println("分组");
        System.out.println(ageMap);
        //多重分组,先根据类型分再根据年龄分
        Map<Integer, Map<Integer, List<Student>>> typeAgeMap = list.stream().collect(Collectors.groupingBy(Student::getType, Collectors.groupingBy(Student::getAge)));
        System.out.println("多重分组");
        System.out.println(typeAgeMap);
        //分区
        //分成两部分，一部分大于10岁，一部分小于等于10岁
        Map<Boolean, List<Student>> partMap = list.stream().collect(Collectors.partitioningBy(v -> v.getAge() > 10));
        System.out.println("分区");
        System.out.println(partMap);
        //规约
        Integer allAge = list.stream().map(Student::getAge).collect(Collectors.reducing(Integer::sum)).get(); //40
        System.out.println("规约");
        System.out.println(allAge);



    }
}
