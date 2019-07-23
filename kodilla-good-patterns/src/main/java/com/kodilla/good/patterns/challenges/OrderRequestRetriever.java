package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestRetriever {
    private static final String ORDER_STATUS = "in progress.";
    public OrderRequest retrieve() {
        User user = new User("Anna", "Kowalska");

        Product product1 = new Product("Marchewka", 2.5);
        Product product2 = new Product("Pietruszka", 4.21);
        Product product3 = new Product("Rzodkiewka", 0.99);
        Product product4 = new Product("Cebula", 1);
        Product product5 = new Product("Pomidor", 8.3);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);

        return new OrderRequest(user, productList, ORDER_STATUS);
}
}
