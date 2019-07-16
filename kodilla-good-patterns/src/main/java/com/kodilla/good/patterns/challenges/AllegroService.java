package com.kodilla.good.patterns.challenges;

import java.util.List;

public class AllegroService implements OrderService {
    public boolean order(final User user, final List<Product> products, final String orderStatus) {
        System.out.println("Order for " + user.getFirstName() + " " + user.getLastName() +
                " status: " + orderStatus);
        return true;
    }
}
