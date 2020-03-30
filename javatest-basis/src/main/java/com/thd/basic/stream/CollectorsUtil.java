package com.thd.basic.stream;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * com.thd.basic.stream.CollectorsUtil
 * 自定义Collectors.GroupBy
 * @author: wanglei62
 * @DATE: 2020/3/30 8:10
 **/



public class CollectorsUtil {
    static final Set<Collector.Characteristics> CH_NOID = Collections.emptySet();

    private CollectorsUtil() {
    }

    @SuppressWarnings("unchecked")
    private static <I, R> Function<I, R> castingIdentity() {
        return i -> (R) i;
    }

    /**
     * Simple implementation class for {@code Collector}.
     *
     * @param <T>
     *            the type of elements to be collected
     * @param <R>
     *            the type of the result
     */
    static class CollectorImpl<T, A, R> implements Collector<T, A, R> {
        private final Supplier<A> supplier;
        private final BiConsumer<A, T> accumulator;
        private final BinaryOperator<A> combiner;
        private final Function<A, R> finisher;
        private final Set<Characteristics> characteristics;

        CollectorImpl(Supplier<A> supplier,
                      BiConsumer<A, T> accumulator,
                      BinaryOperator<A> combiner,
                      Function<A, R> finisher,
                      Set<Characteristics> characteristics) {
            this.supplier = supplier; // 第一个元素
            this.accumulator = accumulator;
            this.combiner = combiner;
            this.finisher = finisher;
            this.characteristics = characteristics;
        }

        CollectorImpl(Supplier<A> supplier, BiConsumer<A, T> accumulator, BinaryOperator<A> combiner,
                      Set<Characteristics> characteristics) {
            this(supplier, accumulator, combiner, castingIdentity(), characteristics);
        }

        @Override
        public BiConsumer<A, T> accumulator() {
            return accumulator;
        }

        @Override
        public Supplier<A> supplier() {
            return supplier;
        }

        @Override
        public BinaryOperator<A> combiner() {
            return combiner;
        }

        @Override
        public Function<A, R> finisher() {
            return finisher;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return characteristics;
        }
    }

    public static <T> Collector<T, ?, BigDecimal> summingBigDecimal(ToBigDecimalFunction<? super T> mapper) {
        return new CollectorImpl<>(
                // 参数1  一个仅包含一个元素的BigDecimal类型的数组
                () -> new BigDecimal[1],

                // 参数2  二元函数(合并函数) 累积计算  参数a:参数1的返回值  参数t:规约的每个元素
                (a, t) -> {
                    if (a[0] == null) {
                        a[0] = BigDecimal.ZERO;
                    }
                    // mapper.applyAsBigDecimal是回调函数，参数是真正用到的实际值
                    a[0] = a[0].add(mapper.applyAsBigDecimal(t));
                },

                // 用于两个两个合并并行执行的线程的执行结果，将其合并为一个最终结果
                (a, b) -> {a[0] = a[0].add(b[0]);return a;},

                // finisher用于将之前整合完的结果R转换成为A
                a -> a[0],

                // characteristics表示当前Collector的特征值，这是个不可变Set
                CH_NOID);
    }
}
