package com.twu.tinystore.Service;

import com.twu.tinystore.domain.Order;
import com.twu.tinystore.dto.OrderDto;
import com.twu.tinystore.domain.Product;
import com.twu.tinystore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderDto orderDto;
    private ProductRepository productRepository;

    @Autowired
    public OrderServiceImpl(OrderDto orderDto, ProductRepository productRepository) {
        this.orderDto = orderDto;
        this.productRepository = productRepository;
    }

    @Override
    public void addToOrder(Product product) {
        orderDto.addProduct(product);
    }

    @Override
    public List<Order> getOrder() {
        return orderDto.getOrder();
    }

    @Override
    public void deleteOrder(int productId) {
        Product product = productRepository.findById(productId).get().toProduct();
        orderDto.removeOrder(product);
    }
}
