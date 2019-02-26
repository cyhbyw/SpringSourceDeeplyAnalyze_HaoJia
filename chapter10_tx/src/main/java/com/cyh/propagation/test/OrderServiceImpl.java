package com.cyh.propagation.test;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author: yanhua.chen
 * @date: 2019/2/26 11:07
 */
public class OrderServiceImpl implements OrderService {
    private JdbcTemplate jdbcTemplate;
    private StorageService storageService;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void saveOrder(OrderPo po) {
        jdbcTemplate.update("INSERT INTO order_tbl(user_id, commodity_code, count, money) VALUES (?, ?, ?, ?)",
                new Object[] {po.getUserId(), po.getCommodityCode(), po.getCount(), po.getMoney()});
        storageService.reduceStorage(po.getCommodityCode(), po.getCount());
    }
}
