package com.cyh.propagation.test;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yanhua.chen
 * @date: 2019/2/26 11:07
 */
public interface OrderService {

    @Transactional
    void saveOrder(OrderPo po);

}
