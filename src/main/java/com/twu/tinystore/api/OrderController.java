package com.twu.tinystore.api;

import com.twu.tinystore.Service.OrderService;
import com.twu.tinystore.domain.Order;
import com.twu.tinystore.dto.OrderDto;
import com.twu.tinystore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getOrder() {
        return ResponseEntity.ok(orderService.getOrder());
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}
