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
    private List<RestaurantOrder> listOfRestaurantOrders;



    public Waiter() {
        this.id = UUID.randomUUID().toString();
        this.listOfRestaurantOrders = new ArrayList<>();
    }

    public void addOrder(String orderDetails, String table, double price) {
        warningWhenLessThanZero(price);
        listOfRestaurantOrders.add(new RestaurantOrder(orderDetails, table, price));
    }

    public void endOrder(String idOrder) {
        for (RestaurantOrder restaurantOrder : listOfRestaurantOrders
        ) {
            if (restaurantOrder.isIdEquals(idOrder)) {
                listOfRestaurantOrders.remove(restaurantOrder);
                restaurantOrder.finishOrder();
                return;
            }

        }
    }

    private void warningWhenLessThanZero(double price) {
        if (price < 0)
            throw new RuntimeException("Price cant be lower than 0");
    }

    boolean checkOrderListSize(int size) {
        return listOfRestaurantOrders.size() == size;
    }

    boolean checkOrderDetails(String orderDetails) {
        for (int i = 0; i < listOfRestaurantOrders.size(); i++) {
            RestaurantOrder restaurantOrder = listOfRestaurantOrders.get(i);
            if (restaurantOrder.isDetailsEquals(orderDetails)) {
                return true;
            }

        }
        return false;
    }

    boolean checkOrderDetails2(String orderDetails) {
        return listOfRestaurantOrders.stream().anyMatch(restaurantOrder -> restaurantOrder.isDetailsEquals(orderDetails));
    }
}
