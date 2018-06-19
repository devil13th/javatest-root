package com.thd.spring.aop.reg;

import org.aspectj.lang.JoinPoint;

public interface Handler {
	public void handler(JoinPoint jp);
}
