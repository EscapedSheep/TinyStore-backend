package com.twu.tinystore.Service;

import com.twu.tinystore.domain.Order;
import com.twu.tinystore.dto.OrderDto;
import com.twu.tinystore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderDto orderDto;

    @Autowired
    public OrderServiceImpl(OrderDto orderDto) {
        this.orderDto = orderDto;
    }

    @Override
    public void addToOrder(Product product) {
        orderDto.addProduct(product);
    }

    @Override
    public List<Order> getOrder() {
        return orderDto.getOrder();
    }
}
