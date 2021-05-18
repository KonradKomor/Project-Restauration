package com.example.demo.orders;

import javax.persistence.*;
import java.util.UUID;
@Entity
class RestaurantOrder {
    @Id
    private  String id;
    private  String orderDetails;
    @Column(name = "RestaurantTable")
    private  String table;
    private  double price;
    private OrderStatus status;

    private RestaurantOrder(){}
    RestaurantOrder(String orderDetails, String table, double price) {
        this.id = UUID.randomUUID().toString();
        this.orderDetails = orderDetails;
        this.table = table;
        this.price = price;
        this.status = OrderStatus.IN_REALIZATION;
    }
    boolean isIdEquals(String id){
        return this.id==id;
    }
    void finishOrder() {
        if (status==OrderStatus.FINISHED){
            throw new IllegalStateException("Order is already finished");
        }
        status = OrderStatus.FINISHED;
    }
    boolean isDetailsEquals(String orderDetails) {
        return this.orderDetails==orderDetails;
    }
}
