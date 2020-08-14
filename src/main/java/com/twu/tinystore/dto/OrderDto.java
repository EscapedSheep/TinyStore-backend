package com.twu.tinystore.dto;

import com.twu.tinystore.domain.Order;
import com.twu.tinystore.domain.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class OrderDto {
    private HashMap<Product, Integer> orders;

    public OrderDto() {
        this.orders = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (orders.containsKey(product)) {
            int count = orders.get(product);
            count += 1;
            orders.put(product, count);
        } else {
            orders.put(product, 1);
        }
    }

    public List<Order> getOrder() {
        List<Order> result = new ArrayList<>();
        for(Map.Entry<Product, Integer> entry : orders.entrySet()) {
            result.add(Order.builder()
                    .id(entry.getKey().getId())
                    .name(entry.getKey().getName())
                    .price(entry.getKey().getPrice())
                    .count(entry.getValue())
                    .unit(entry.getKey().getUnit())
                    .build());
        }
        return result;
    }

    public void removeOrder(Product product) {
        orders.remove(product);
    }
}
