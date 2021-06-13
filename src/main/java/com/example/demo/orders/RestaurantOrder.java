package com.example.demo.orders;

import javax.persistence.*;
import java.util.UUID;

@Entity
class RestaurantOrder {


    @Id
    private String id;
    private String orderDetails;
    @Column(name = "RestaurantTable")
    private String table;
    private double price;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private RestaurantOrder() {
    }

    RestaurantOrder(String id, String orderDetails, String table, double price) {
        this.id = id;
        this.orderDetails = orderDetails;
        this.table = table;
        this.price = price;
        this.status = OrderStatus.IN_REALIZATION;
    }

    boolean isIdEquals(String id) {
        return this.id.equals(id);
    }

    void finishOrder() {
        if (status == OrderStatus.FINISHED) {
            throw new IllegalStateException("Order is already finished");
        }
        status = OrderStatus.FINISHED;
    }


    boolean isDetailsEquals(String orderDetails) {
        return this.orderDetails == orderDetails;
    }
}
