package com.kodilla.good.patterns.challenges;

import java.util.List;

class ShopRepository implements OrderRepository {
    public boolean createOrder(User user, final List<Product> products, final String orderStatus) {
        System.out.println("Order nr 1234568 was created.\nOrdered products: ");
        for (Product product: products) {
            System.out.println(product);
        }
        return true;
    }
}
