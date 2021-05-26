package com.example.demo;

public class RestauranOrderDto {
    final String id;
    final String orderDetails;
    final String table;
    final double price;

    public RestauranOrderDto(String id, String orderDetails, String table, double price) {
        this.id = id;
        this.orderDetails = orderDetails;
        this.table = table;
        this.price = price;
    }
}
