package br.com.nicolas.my_stock.model;

public enum ShippingMethod {
    STANDART("standart"),
    EXPRESS("express");

    final String shippingMethod;


    ShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
