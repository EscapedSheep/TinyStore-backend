package com.twu.tinystore.Service;

import com.twu.tinystore.domain.Order;
import com.twu.tinystore.dto.OrderDto;
import com.twu.tinystore.domain.Product;

import java.util.List;

public interface OrderService {
    void addToOrder(Product product);

    List<Order> getOrder();
}
