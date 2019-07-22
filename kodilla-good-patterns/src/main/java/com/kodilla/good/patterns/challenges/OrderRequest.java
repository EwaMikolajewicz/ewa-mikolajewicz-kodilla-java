package com.kodilla.good.patterns.challenges;

import java.util.List;

public class OrderRequest {
    private User user;
    private List<Product> productList;
    private String orderStatus;

    public OrderRequest(final User user,
                        final List<Product> productList,
                        final String orderStatus) {
        this.user = user;
        this.productList = productList;
        this.orderStatus = orderStatus;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}
