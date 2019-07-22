package com.kodilla.good.patterns.challenges;

import java.util.List;

public interface OrderRepository {
    boolean createOrder(User user, final List<Product> products, final String orderStatus);
}
