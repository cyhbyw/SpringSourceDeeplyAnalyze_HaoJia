package com.cyh.propagation.test;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yanhua.chen
 * @date: 2019/2/26 11:07
 */
public class StorageServiceImpl implements StorageService {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Transactional
    @Override
    public void reduceStorage(String commodityCode, Integer count) {
        jdbcTemplate.update("UPDATE storage_tbl SET count = count - ? WHERE commodity_code = ?",
                new Object[] {count, commodityCode});
    }
}
