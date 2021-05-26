package com.example.demo;

import com.example.demo.orders.Waiter;
import com.example.demo.orders.WaiterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    private final WaiterRepository repository;

    Controller(final WaiterRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    ResponseEntity<Waiter> hireWaiter(@RequestParam String id) {
        return ResponseEntity.ok(repository.save(new Waiter(id)));
    }

    @PostMapping("/orders/add/{id}")
    ResponseEntity<Waiter> addOrder(@PathVariable String id, @RequestBody RestauranOrderDto order) {
        Waiter waiter = repository.findById(id).get();
        waiter.addOrder(order.id, order.orderDetails, order.table, order.price);
        return ResponseEntity.ok(repository.save(waiter));
    }


    @PostMapping("/waiters/{id}/end/{ido}")
    ResponseEntity<Waiter> endOrder(@PathVariable String id, @PathVariable String ido) {
        Waiter waiter = repository.findById(id).get();
        waiter.endOrder(ido);
        return ResponseEntity.ok(repository.save(waiter));
    }
}

