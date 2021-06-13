package com.example.demo.finder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
public class OrdersFinder {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<FindOrderDto> getAllOrders() {
        List<FindOrderDto> results = jdbcTemplate.query("SELECT * FROM RESTAURANT_ORDER",
                new RowMapper<FindOrderDto>() {
                    @Override
                    public FindOrderDto mapRow(ResultSet resultSet, int i) throws SQLException {
                        return new FindOrderDto(
                                resultSet.getString("ID"),
                                resultSet.getString("ORDER_DETAILS"),
                                resultSet.getString("RESTAURANT_TABLE"),
                                resultSet.getString("STATUS"),
                                resultSet.getDouble("PRICE")
                        );
                    }
                });
        if (results.isEmpty())
            return Collections.emptyList();
        return results;
    }
}