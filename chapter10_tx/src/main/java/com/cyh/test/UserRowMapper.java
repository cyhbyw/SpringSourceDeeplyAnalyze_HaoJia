package com.cyh.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet res, int i) throws SQLException {
        return new User(res.getInt("id"), res.getString("name"), res.getInt("age"), res.getString("sex"));
    }
}
