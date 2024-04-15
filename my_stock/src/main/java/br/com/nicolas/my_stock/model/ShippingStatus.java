package br.com.nicolas.my_stock.model;


public enum ShippingStatus {
    PENDING("pending"),
    SHIPPED("shipped"),
    DELIVERED("delivered");

    String status;

    ShippingStatus(String status) {
        this.status = status;
    }
}
