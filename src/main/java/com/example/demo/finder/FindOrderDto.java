package com.example.demo.finder;

public class FindOrderDto {

        private final String id;
        private final String orderDetails;
        private final String table;
        private final String status;
        private final double price;

        FindOrderDto(String id, String orderDetails, String table, String status, double price) {
            this.id = id;
            this.orderDetails = orderDetails;
            this.table = table;
            this.status = status;
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public String getOrderDetails() {
            return orderDetails;
        }

        public String getTable() {
            return table;
        }

        public String getStatus() {
            return status;
        }

        public double getPrice() {
            return price;
        }
    }

