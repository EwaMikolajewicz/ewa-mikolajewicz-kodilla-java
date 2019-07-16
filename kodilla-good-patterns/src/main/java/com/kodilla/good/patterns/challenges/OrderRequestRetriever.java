package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestRetriever {
    public OrderRequest retrieve(){
        User user = new User("Anna", "Kowalska");

        List<Product> productList = new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            Product product = new Product("Product " + i,33.5-i*1.3
            );
            productList.add(product);
        }

        String orderStatus = "in process";

        return new OrderRequest(user,productList, orderStatus);
    }
}
