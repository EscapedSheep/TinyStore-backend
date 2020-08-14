package com.twu.tinystore.Service;

import com.twu.tinystore.domain.Order;
import com.twu.tinystore.domain.Product;

public interface OrderService {
    void addToOrder(Product product);

    Order getOrder();
}
