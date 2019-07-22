package com.kodilla.good.patterns.challenges;

import java.util.List;

public interface OrderService {
    boolean order (final User user, final List<Product> products, final String orderStatus);

}
