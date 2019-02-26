package com.cyh.propagation.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: yanhua.chen
 * @date: 2019/2/26 11:20
 */
public class OrderServiceTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("userService.xml");
        OrderService orderService = context.getBean(OrderService.class);
        OrderPo po = new OrderPo();
        po.setUserId("cyh");
        po.setCommodityCode("lightSuite");
        po.setCount(5);
        po.setMoney(1699);
        orderService.saveOrder(po);
        context.close();
    }

}
