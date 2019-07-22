package com.kodilla.good.patterns.challenges;

public class Product {
    private final String productName;
    private final double productPrice;

    public Product(final String productName, final double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product: " + productName + ", price: " + productPrice;
    }
}
