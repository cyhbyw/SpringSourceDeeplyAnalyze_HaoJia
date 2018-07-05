package com.cyh;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop-context.xml");
        context.getBean(TestBean.class).test();
    }

}
