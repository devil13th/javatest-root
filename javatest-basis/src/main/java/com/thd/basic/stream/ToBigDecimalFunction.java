package com.thd.basic.stream;

import java.math.BigDecimal;

/**
 * com.thd.basic.stream.ToBigDecimalFunction
 *
 * @author: wanglei62
 * @DATE: 2020/3/30 8:11
 **/
@FunctionalInterface
public interface ToBigDecimalFunction<T> {
    BigDecimal applyAsBigDecimal(T value);
}
