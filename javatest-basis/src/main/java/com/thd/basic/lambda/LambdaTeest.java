package com.thd.basic.lambda;

import junit.framework.TestCase;
import org.junit.Test;

public class LambdaTeest extends TestCase {
    @Test
    public void test01(){
        Thread thread = new Thread(() -> {System.out.println("lambda");});
        thread.start();

        System.out.println("finish");
    }
}
