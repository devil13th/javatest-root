package com.thd.spring.annotation.ioc.beanpostprocessor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
	@AliasFor(annotation = MyAnnotation.class, attribute = "transferTo")
	String value() default "";
	@AliasFor("value")
	String transferTo() default "";
}
