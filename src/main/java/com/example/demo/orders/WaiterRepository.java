package com.example.demo.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public interface WaiterRepository extends JpaRepository<Waiter,String> {

}
