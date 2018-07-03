package com.cyh.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTransactionTest {


    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("userService.xml");
        UserService userService = context.getBean(UserService.class);
        userService.save(new User(null, "CYH", 28, "Male"));
    }

}
