package com.example.demo.orders;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Waiter {
    @Id
    private String id;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "Waiter")
    private List<Order> listOfOrders;



    public Waiter() {
        this.id = UUID.randomUUID().toString();
        this.listOfOrders = new ArrayList<>();
    }

    public void addOrder(String orderDetails, String table, double price) {
        warningWhenLessThanZero(price);
        listOfOrders.add(new Order(orderDetails, table, price));
    }

    public void endOrder(String idOrder) {
        for (Order order : listOfOrders
        ) {
            if (order.isIdEquals(idOrder)) {
                listOfOrders.remove(order);
                order.finishOrder();
                return;
            }

        }
    }

    private void warningWhenLessThanZero(double price) {
        if (price < 0)
            throw new RuntimeException("Price cant be lower than 0");
    }

    boolean checkOrderListSize(int size) {
        return listOfOrders.size() == size;
    }

    boolean checkOrderDetails(String orderDetails) {
        for (int i = 0; i < listOfOrders.size(); i++) {
            Order order = listOfOrders.get(i);
            if (order.isDetailsEquals(orderDetails)) {
                return true;
            }

        }
        return false;
    }

    boolean checkOrderDetails2(String orderDetails) {
        return listOfOrders.stream().anyMatch(order -> order.isDetailsEquals(orderDetails));
    }
}
