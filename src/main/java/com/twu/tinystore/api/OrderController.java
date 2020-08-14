package com.twu.tinystore.api;

import com.twu.tinystore.Service.OrderService;
import com.twu.tinystore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity addToOrder(@RequestBody Product product) {
        orderService.addToOrder(product);
        System.out.println(orderService.getOrder().getOrderList().get(0));
        return ResponseEntity.created(null).build();
    }
}
