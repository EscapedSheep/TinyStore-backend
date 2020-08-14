package com.twu.tinystore.Service;

import com.twu.tinystore.domain.Order;
import com.twu.tinystore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private Order order;

    @Autowired
    public OrderServiceImpl(Order order) {
        this.order = order;
    }

    @Override
    public void addToOrder(Product product) {
        order.addProduct(product);
    }

    @Override
    public Order getOrder() {
        return order;
    }
}
