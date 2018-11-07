package com.cyh.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTransactionTest {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("userService.xml");
        try {
            context.getBean(UserService.class).save(new User(null, "CYH", 28, "Male"));
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        context.getBean(UserServiceWithoutTransaction.class).save(new User(null, "CYH", 29, "Male"));
        context.close();
    }

}
