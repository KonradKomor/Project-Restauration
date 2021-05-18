package com.example.demo.services;

import com.example.demo.orders.Waiter;
import com.example.demo.orders.WaiterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private WaiterRepository repository;
    @PostConstruct
    void addLasagne(){
        Waiter waiter = new Waiter();
        waiter.addOrder("Lasagne", "2", 25);
        repository.save(waiter);
    }
}
