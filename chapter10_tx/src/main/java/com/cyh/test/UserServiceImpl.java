package com.cyh.test;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void save(User user) throws Exception {
        jdbcTemplate.update("INSERT INTO tx_user(name, age, sex) VALUES (?, ?, ?)", new Object[] {user.getName(),
                user.getAge(), user.getSex(), new int[] {Types.VARCHAR, Types.INTEGER, Types.VARCHAR}});

        int x = 1 / 0;
    }
}