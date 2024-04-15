package br.com.nicolas.my_stock.model;

public enum PaymentMethod {
    PIX("pix"),
    CASH("cash"),
    CARD("card");

    final String paymentMethod;

    PaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
